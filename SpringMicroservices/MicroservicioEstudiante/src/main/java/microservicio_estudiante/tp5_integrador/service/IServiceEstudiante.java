package microservicio_estudiante.tp5_integrador.service;

import microservicio_estudiante.tp5_integrador.dto.EstudianteCarreraDTO;
import microservicio_estudiante.tp5_integrador.dto.EstudianteInscriptoGraduadoDTO;
import microservicio_estudiante.tp5_integrador.dto.InscriptosCountDTO;
import microservicio_estudiante.tp5_integrador.entity.Estudiante;

import java.util.List;
import java.util.Optional;

public interface IServiceEstudiante {

    // Consulta personalizada para encontrar estudiantes por género
    public List<Estudiante> findByGenero(String genero);

    // Consulta personalizada para ordenar por apellido
    public List<Estudiante> findAllByOrderByApellidoAsc();

    // Otra consulta personalizada para buscar estudiantes en una ciudad específica
    public List<EstudianteCarreraDTO> findEstudiantesByCarreraAndCiudad(String ciudadResidencia, Long idCarrera);

    public Optional<Estudiante> findById(String id);

    public List<Estudiante> findAll();

    public List<EstudianteInscriptoGraduadoDTO> findEstudianteInscriptoGraduado();

    public List<InscriptosCountDTO> obtenerCantidadInscriptos();



}
