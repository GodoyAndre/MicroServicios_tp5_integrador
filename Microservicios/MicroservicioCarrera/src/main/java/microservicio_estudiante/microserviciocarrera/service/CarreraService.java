package microservicio_estudiante.microserviciocarrera.service;

import microservicio_estudiante.microserviciocarrera.dto.CarreraInscriptosDTO;
import microservicio_estudiante.microserviciocarrera.dto.EstudiantesInscriptosGraduadosDTO;
import microservicio_estudiante.microserviciocarrera.repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarreraService {
    @Autowired
    private CarreraRepository carreraRepository;

    public List<CarreraInscriptosDTO> findCarrerasWithInscritos(){
        return carreraRepository.findCarrerasWithInscritos();
    }

    public List<EstudiantesInscriptosGraduadosDTO> obtenerReporteInscriptosGraduadosCarrera(){
        return carreraRepository.obtenerReporteInscriptosGraduadosCarrera();
    }
}
