package microserviciocarrera.service;

import microserviciocarrera.client.EstudianteServiceClient;
import microserviciocarrera.dto.CarreraInscriptosDTO;
import microserviciocarrera.dto.EstudiantesInscriptosGraduadosDTO;
import microserviciocarrera.dto.InscriptosCountDTO;
import microserviciocarrera.entity.Carrera;
import microserviciocarrera.repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarreraService implements ICarreraService {
    @Autowired
    private CarreraRepository carreraRepository;

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
        return carreraRepository.obtenerReporteInscriptosGraduadosCarrera();
    }

    public Optional<Carrera> findById(Long id){
        return carreraRepository.findById(id);
    }
}
