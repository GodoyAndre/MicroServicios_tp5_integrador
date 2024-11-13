package microserviciocarrera.repository;


import microserviciocarrera.dto.CarreraInscriptosDTO;
import microserviciocarrera.dto.EstudiantesInscriptosGraduadosDTO;
import microserviciocarrera.entity.Carrera;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarreraRepository extends CrudRepository<Carrera, Long> {

    //List<CarreraInscriptosDTO> findCarrerasWithInscritos();


    //List<EstudiantesInscriptosGraduadosDTO> obtenerReporteInscriptosGraduadosCarrera();

    Optional<Carrera> findById(Long id);
}


