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

import java.net.URI;
import java.net.URISyntaxException;
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

    @GetMapping("/all-by-apellidos")
    public ResponseEntity<?> getEstudiantes() {
        List<Estudiante> estudiantes = estudianteService.findAllByOrderByApellidoAsc();

        return ResponseEntity.ok(estudiantes);
    }

    @GetMapping("/find/{genero}")
    public ResponseEntity<?> getEstudianteByGenero(@PathVariable String genero) {
        Optional<List<Estudiante>> estudiantes = Optional.ofNullable(estudianteService.findByGenero(genero.toUpperCase()));

        if (estudiantes.isPresent()) {
            return ResponseEntity.ok(estudiantes.get());
        }
        return ResponseEntity.notFound().build();
    }

    // Endpoint para obtener todos los estudiantes
    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        List<Estudiante> estudiantes = estudianteService.findAll();
        return ResponseEntity.ok(estudiantes);
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

    @PostMapping("/crear")
    public ResponseEntity<Estudiante> addEstudiante(@RequestBody Estudiante estudiante) throws URISyntaxException {
        estudianteService.save(Estudiante.builder()
                .numeroLibretaUniversitaria(estudiante.getNumeroLibretaUniversitaria())
                .apellido(estudiante.getApellido())
                .nombres(estudiante.getNombres())
                .edad(estudiante.getEdad())
                .documento(estudiante.getDocumento())
                .genero(estudiante.getGenero()).build());
        return ResponseEntity.created(new URI("/estudiantes/crear")).build();
    }
}

