package microservicio_estudiante.tp5_integrador.service;

import microservicio_estudiante.tp5_integrador.dto.EstudianteCarreraDTO;
import microservicio_estudiante.tp5_integrador.entity.Estudiante;
import microservicio_estudiante.tp5_integrador.jparepository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EstudianteService  {
    @Autowired
    private EstudianteRepository estudianteRepository;

    // Consulta personalizada para encontrar estudiantes por género
    public List<Estudiante> findByGenero(String genero){
        return estudianteRepository.findByGenero(genero);
    }

    // Consulta personalizada para ordenar por apellido
    public List<Estudiante> findAllByOrderByApellidoAsc(){
        return estudianteRepository.findAllByOrderByApellidoAsc();
    }

    // Otra consulta personalizada para buscar estudiantes en una ciudad específica
    public List<EstudianteCarreraDTO> findByCiudadResidenciaAndGenero(String ciudadResidencia, String genero){
        return estudianteRepository.findByCiudadResidenciaAndGenero(ciudadResidencia, genero);
    }

    public Optional<Estudiante> findById(String id){
        return estudianteRepository.findById(id);
    }

    public List<Estudiante> findAll() {
        return (List<Estudiante>) estudianteRepository.findAll();
    }
}
