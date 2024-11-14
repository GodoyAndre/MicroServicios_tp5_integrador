package microservicio_estudiante.tp5_integrador.service;

import feign.Param;
import jakarta.transaction.Transactional;
import microservicio_estudiante.tp5_integrador.client.CarreraClient;
import microservicio_estudiante.tp5_integrador.dto.EstudianteCarreraDTO;
import microservicio_estudiante.tp5_integrador.dto.EstudianteInscriptoGraduadoDTO;
import microservicio_estudiante.tp5_integrador.dto.InscriptosCountDTO;
import microservicio_estudiante.tp5_integrador.entity.Estudiante;
import microservicio_estudiante.tp5_integrador.entity.Matricula;
import microservicio_estudiante.tp5_integrador.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstudianteService implements IServiceEstudiante {
    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private CarreraClient carreraClient;

    // Consulta personalizada para encontrar estudiantes por género
    public List<Estudiante> findByGenero(String genero) {
        return estudianteRepository.findByGenero(genero);
    }

    // Consulta personalizada para ordenar por apellido
    public List<Estudiante> findAllByOrderByApellidoAsc() {
        return estudianteRepository.findAllByOrderByApellidoAsc();
    }

    // Otra consulta personalizada para buscar estudiantes en una ciudad específica
    public List<EstudianteCarreraDTO> findEstudiantesByCarreraAndCiudad(String ciudadResidencia, Long idCarrera) {
        String nombreCarrera = carreraClient.getNombreCarreraById(idCarrera);
        List<EstudianteCarreraDTO> estudiantes = estudianteRepository.findEstudiantesByCarreraAndCiudad(ciudadResidencia, idCarrera);
        //estudiantes.forEach(estudiante -> estudiante.setNombreCarrera(nombreCarrera));
        return estudiantes.stream().peek(c -> c.setNombreCarrera(nombreCarrera)).collect(Collectors.toList());
    }

    public Optional<Estudiante> findById(String id) {
        return estudianteRepository.findById(id);
    }

    public List<Estudiante> findAll() {
        return (List<Estudiante>) estudianteRepository.findAll();
    }

    @Override
    public List<EstudianteInscriptoGraduadoDTO> findEstudianteInscriptoGraduado() {
        return estudianteRepository.findEstudianteInscriptoGraduado();
    }

    public List<InscriptosCountDTO> obtenerCantidadInscriptos() {
        return estudianteRepository.findInscriptosCountByCarrera();
    }

    public Estudiante updateIdCarrera(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    public List<Estudiante> findByIdCarrera(Long idCarrera) {
        return estudianteRepository.findByIdCarrera(idCarrera);
    }

    @Transactional
    public void actualizarCarreraEstudiantes(Long idCarreraAntiguo, Long idCarreraNuevo) {
        List<Estudiante> estudiantes = estudianteRepository.findByIdCarrera(idCarreraAntiguo);
        if (estudiantes.isEmpty()) {
            System.out.println("No se encontraron estudiantes con el idCarreraAntiguo: " + idCarreraAntiguo);
        }
        for (Estudiante estudiante : estudiantes) {
            boolean updated = false;
            for (Matricula matricula : estudiante.getMatriculas()) {
                if (matricula.getIdCarrera().equals(idCarreraAntiguo)) {
                    matricula.setIdCarrera(idCarreraNuevo);
                    updated = true;
                    System.out.println("Actualizado el idCarrera en matrícula para estudiante: " + estudiante.getNumeroLibretaUniversitaria());
                }
            }
            if (updated) {
                estudianteRepository.save(estudiante);
            }
        }

    }

    public Estudiante save(Estudiante estudiante){
        return estudianteRepository.save(estudiante);
    }

}
