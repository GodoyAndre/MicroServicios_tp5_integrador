package microserviciocarrera.service;

import microserviciocarrera.client.EstudianteServiceClient;
import microserviciocarrera.dto.CarreraInscriptosDTO;
import microserviciocarrera.dto.EstudianteDTO;
import microserviciocarrera.dto.EstudiantesInscriptosGraduadosDTO;
import microserviciocarrera.dto.InscriptosCountDTO;
import microserviciocarrera.entity.Carrera;
import microserviciocarrera.repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarreraService implements ICarreraService {
    @Autowired
    private CarreraRepository carreraRepository;

    @Autowired
    private CarreraEventPublisher eventPublisher;

    @Autowired
    private EstudianteServiceClient estudianteServiceClient;

    public List<CarreraInscriptosDTO> obtenerCarrerasConInscriptos() {
        // Obtener conteos desde el microservicio de Estudiantes
        List<InscriptosCountDTO> conteos = estudianteServiceClient.obtenerCantidadInscriptos();

        // Obtener las carreras desde el repositorio local
        List<Carrera> carreras = (List<Carrera>) carreraRepository.findAll();

        // Mapear las carreras con los conteos
        return conteos.stream()
                .map(conteo -> {
                    Carrera carrera = carreras.stream()
                            .filter(c -> c.getId().equals(conteo.getIdCarrera()))
                            .findFirst()
                            .orElseThrow(() -> new RuntimeException("Carrera no encontrada"));
                    return new CarreraInscriptosDTO(carrera.getNombre(), conteo.getCantInscriptos());
                })
                .sorted(Comparator.comparingLong(CarreraInscriptosDTO::getCantInscriptos).reversed())
                .toList();
    }


    public List<EstudiantesInscriptosGraduadosDTO> obtenerReporteInscriptosGraduadosCarrera(){
        List<EstudianteDTO> estudiantes = estudianteServiceClient.findEstudianteInscriptoGraduado();
        List<Carrera> carreras = (List<Carrera>) carreraRepository.findAll();
        Map<Long, String> idToNombreCarrera = carreras.stream()
                .collect(Collectors.toMap(Carrera::getId, Carrera::getNombre));

        // Enriquecer datos y mapear a EstudiantesInscriptosGraduadosDTO
        return estudiantes.stream()
                .map(m -> new EstudiantesInscriptosGraduadosDTO(
                        m.getNombres(),
                        m.getApellidos(),
                        m.getNumeroLibreta(),
                        idToNombreCarrera.get(m.getIdCarrera()),
                        m.getGraduado() ? "Graduado" : "Inscripto",
                        m.getAnio()
                ))
                .sorted(Comparator.comparing(EstudiantesInscriptosGraduadosDTO::getNombreCarrera)
                        .thenComparing(EstudiantesInscriptosGraduadosDTO::getAnio))
                .toList();
    }

    public Optional<Carrera> findById(Long id){
        return carreraRepository.findById(id);
    }


    public Carrera actualizarCarrera(Long id, Carrera carreraNueva) {

        System.out.println("id: " + id);
        if (carreraRepository.existsById(carreraNueva.getId())) {
            throw new RuntimeException("El id " + carreraNueva.getId() + " ya está en uso");
        }
        Carrera carreraExistente = carreraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrera no encontrada"));

        if (!carreraExistente.getId().equals(carreraNueva.getId())) {
            // Publica un evento solo si el idCarrera ha cambiado
            eventPublisher.publishCarreraActualizada(carreraExistente.getId(), carreraNueva.getId());
        }

        Carrera nueva = Carrera.builder()
                .id(carreraNueva.getId())
                .nombre(carreraNueva.getNombre())
                        .build();
        carreraRepository.delete(carreraExistente);
        //carreraExistente.setId(carreraNueva.getId());
        return carreraRepository.save(nueva);
    }

    public List<Carrera> getAllCarreras(){
        return (List<Carrera>) carreraRepository.findAll();
    }

}
