package microservicio_estudiante.tp5_integrador.controller;

import microservicio_estudiante.tp5_integrador.entity.Estudiante;
import microservicio_estudiante.tp5_integrador.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    // Endpoint para obtener todos los estudiantes
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Estudiante>> getEstudiante(@PathVariable String id) {
        Optional<Estudiante> estudiante = estudianteService.findById(id);

        if (estudiante.isPresent()) {
            return ResponseEntity.ok(estudiante);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para obtener todos los estudiantes
    @GetMapping
    public List<Estudiante> findAll() {
        return estudianteService.findAll();
    }
}

