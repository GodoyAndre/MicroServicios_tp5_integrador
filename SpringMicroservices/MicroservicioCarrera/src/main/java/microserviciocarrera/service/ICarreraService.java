package microserviciocarrera.service;

import microserviciocarrera.dto.CarreraInscriptosDTO;
import microserviciocarrera.dto.EstudiantesInscriptosGraduadosDTO;
import microserviciocarrera.entity.Carrera;

import java.util.List;
import java.util.Optional;

public interface ICarreraService {
    public List<CarreraInscriptosDTO> obtenerCarrerasConInscriptos();

    public List<EstudiantesInscriptosGraduadosDTO> obtenerReporteInscriptosGraduadosCarrera();

    public Optional<Carrera> findById(Long id);
}
