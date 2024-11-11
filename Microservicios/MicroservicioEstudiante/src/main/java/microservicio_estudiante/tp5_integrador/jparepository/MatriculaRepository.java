package microservicio_estudiante.tp5_integrador.jparepository;

import microservicio_estudiante.tp5_integrador.dto.MatriculasDTO;
import microservicio_estudiante.tp5_integrador.entity.Estudiante;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatriculaRepository extends CrudRepository<Estudiante, String> {
    @Query("SELECT e FROM Matricula e ORDER BY e.id")
    List<MatriculasDTO> findAllMatriculas();
}
