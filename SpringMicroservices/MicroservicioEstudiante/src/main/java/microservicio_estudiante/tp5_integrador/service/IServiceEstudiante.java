package microservicio_estudiante.tp5_integrador.service;

import microservicio_estudiante.tp5_integrador.dto.EstudianteCarreraDTO;
import microservicio_estudiante.tp5_integrador.dto.EstudianteInscriptoGraduadoDTO;
import microservicio_estudiante.tp5_integrador.dto.InscriptosCountDTO;
import microservicio_estudiante.tp5_integrador.entity.Estudiante;

import java.util.List;
import java.util.Optional;

public interface IServiceEstudiante {

    // Consulta personalizada para encontrar estudiantes por género
    List<Estudiante> findByGenero(String genero);

    // Consulta personalizada para ordenar por apellido
    List<Estudiante> findAllByOrderByApellidoAsc();

    // Otra consulta personalizada para buscar estudiantes en una ciudad específica
    List<EstudianteCarreraDTO> findEstudiantesByCarreraAndCiudad(String ciudadResidencia, Long idCarrera);

    Optional<Estudiante> findById(String id);

    List<Estudiante> findAll();

    List<EstudianteInscriptoGraduadoDTO> findEstudianteInscriptoGraduado();

    List<InscriptosCountDTO> obtenerCantidadInscriptos();

    List<Estudiante> findByIdCarrera(Long idCarrera);

    void actualizarCarreraEstudiantes(Long idCarreraAntiguo, Long idCarreraNuevo);

    Estudiante save(Estudiante estudiante);

}
