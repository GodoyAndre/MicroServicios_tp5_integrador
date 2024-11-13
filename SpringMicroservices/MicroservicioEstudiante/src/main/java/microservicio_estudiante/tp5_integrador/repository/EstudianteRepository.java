package microservicio_estudiante.tp5_integrador.repository;

import microservicio_estudiante.tp5_integrador.dto.EstudianteCarreraDTO;
import microservicio_estudiante.tp5_integrador.dto.EstudianteInscriptoGraduadoDTO;
import microservicio_estudiante.tp5_integrador.dto.InscriptosCountDTO;
import microservicio_estudiante.tp5_integrador.entity.Estudiante;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstudianteRepository extends CrudRepository<Estudiante, String> {
    // Consulta personalizada para encontrar estudiantes por género
    public List<Estudiante> findByGenero(String genero);

    // Consulta personalizada para ordenar por apellido
    public List<Estudiante> findAllByOrderByApellidoAsc();

    // Otra consulta personalizada para buscar estudiantes en una ciudad específica
    @Query("SELECT new microservicio_estudiante.tp5_integrador.dto.EstudianteCarreraDTO(e.nombres, e.apellido, e.ciudadResidencia, :nombreCarrera) " +
            "FROM Estudiante e JOIN e.matriculas m " +
            "WHERE m.idCarrera = :idCarrera AND e.ciudadResidencia = :ciudad")
    public List<EstudianteCarreraDTO> findEstudiantesByCarreraAndCiudad(String ciudad, String nombreCarrera);

    public Optional<Estudiante> findById(String id);

    @Query("SELECT NEW microservicio_estudiante.tp5_integrador.dto.EstudianteInscriptoGraduadoDTO(e.numeroLibretaUniversitaria, m.graduado, m.fechaInscripcion, e.apellido, e.nombres, m.idCarrera)" +
            "FROM Matricula m JOIN m.estudiante e")
    public List<EstudianteInscriptoGraduadoDTO> findEstudianteInscriptoGraduado();

    @Query("SELECT new microservicio_estudiante.tp5_integrador.dto.InscriptosCountDTO(m.idCarrera, COUNT(m)) " +
            "FROM Estudiante e JOIN e.matriculas m " +
            "GROUP BY m.idCarrera")
    public List<InscriptosCountDTO> findInscriptosCountByCarrera();





}

