package microservicio_estudiante.tp5_integrador.jparepository;

import microservicio_estudiante.tp5_integrador.dto.EstudianteCarreraDTO;
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
    @Query("SELECT e FROM Estudiante e ORDER BY e.nombres ASC")
    public List<EstudianteCarreraDTO> findByCiudadResidenciaAndGenero(String ciudadResidencia, String genero);

    public Optional<Estudiante> findById(String id);




}

