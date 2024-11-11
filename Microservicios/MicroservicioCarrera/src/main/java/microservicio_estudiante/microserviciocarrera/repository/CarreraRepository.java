package microservicio_estudiante.microserviciocarrera.repository;


import microservicio_estudiante.microserviciocarrera.dto.CarreraInscriptosDTO;
import microservicio_estudiante.microserviciocarrera.dto.EstudiantesInscriptosGraduadosDTO;
import microservicio_estudiante.microserviciocarrera.entity.Carrera;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarreraRepository extends CrudRepository<Carrera, String> {


    public List<CarreraInscriptosDTO> findCarrerasWithInscritos();

    public List<EstudiantesInscriptosGraduadosDTO> obtenerReporteInscriptosGraduadosCarrera();
}


