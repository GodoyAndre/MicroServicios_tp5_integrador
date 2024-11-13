package microserviciocarrera.service;

import microserviciocarrera.dto.CarreraInscriptosDTO;
import microserviciocarrera.dto.EstudiantesInscriptosGraduadosDTO;
import microserviciocarrera.entity.Carrera;

import java.util.List;
import java.util.Optional;

public interface ICarreraService {
    List<CarreraInscriptosDTO> obtenerCarrerasConInscriptos();

    List<EstudiantesInscriptosGraduadosDTO> obtenerReporteInscriptosGraduadosCarrera();

    Optional<Carrera> findById(Long id);
}
