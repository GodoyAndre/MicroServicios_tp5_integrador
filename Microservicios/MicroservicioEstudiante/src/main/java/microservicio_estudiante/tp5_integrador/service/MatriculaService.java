package microservicio_estudiante.tp5_integrador.service;

import microservicio_estudiante.tp5_integrador.dto.MatriculasDTO;
import microservicio_estudiante.tp5_integrador.jparepository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaService{
    @Autowired
    private MatriculaRepository matriculaRepository;

    public List<MatriculasDTO> findAllMatriculas() {
        return matriculaRepository.findAllMatriculas();
    }
}
