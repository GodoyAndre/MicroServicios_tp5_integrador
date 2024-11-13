package microservicio_estudiante.tp5_integrador.controller;

import microservicio_estudiante.tp5_integrador.dto.EstudianteCarreraDTO;
import microservicio_estudiante.tp5_integrador.dto.EstudianteInscriptoGraduadoDTO;
import microservicio_estudiante.tp5_integrador.dto.InscriptosCountDTO;
import microservicio_estudiante.tp5_integrador.entity.Estudiante;
import microservicio_estudiante.tp5_integrador.service.EstudianteService;
import microservicio_estudiante.tp5_integrador.service.IServiceEstudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private IServiceEstudiante estudianteService;

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

    @GetMapping("/buscar/{idCarrera}/{ciudad}")
    public List<EstudianteCarreraDTO> findEstudiantesByCarreraAndCiudad(@PathVariable("idCarrera") Long idCarrera, @PathVariable("ciudad") String ciudad) {
        return estudianteService.findEstudiantesByCarreraAndCiudad(ciudad, idCarrera);
    }

    @GetMapping("/cantidad-inscriptos")
    public ResponseEntity<?> obtenerCantidadInscriptos() {
        return ResponseEntity.ok(estudianteService.obtenerCantidadInscriptos());
    }

    @GetMapping("/reporte-estudiantes")
    public ResponseEntity<?> findEstudianteInscriptoGraduado(){
        return ResponseEntity.ok(estudianteService.findEstudianteInscriptoGraduado());
    }
}

