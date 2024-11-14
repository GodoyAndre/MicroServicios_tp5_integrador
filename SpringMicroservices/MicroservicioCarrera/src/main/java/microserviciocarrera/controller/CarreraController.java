package microserviciocarrera.controller;

import microserviciocarrera.dto.CarreraInscriptosDTO;
import microserviciocarrera.dto.EstudiantesInscriptosGraduadosDTO;
import microserviciocarrera.entity.Carrera;
import microserviciocarrera.service.ICarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carreras")
public class CarreraController {

    @Autowired
    private ICarreraService carreraService;

    //endpoint
    @GetMapping("/search-ny-student/{idCarrera}")
    public ResponseEntity<String> getNombreCarreraById(@PathVariable Long idCarrera) {
        Optional<Carrera> carrera = carreraService.findById(idCarrera);
        if (carrera.isPresent()) {
            return ResponseEntity.ok(carrera.get().getNombre());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCarreraById(@PathVariable Long id) {
        Optional<Carrera> carrera = carreraService.findById(id);
        if (carrera.isPresent()) {
            Carrera car = carrera.get();
            return ResponseEntity.ok(car);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/con-inscriptos")
    public List<CarreraInscriptosDTO> getCarrerasWithInscriptos(){
        return carreraService.obtenerCarrerasConInscriptos();
    }

    @GetMapping("/reporte-inscriptos-graduados")
    public List<EstudiantesInscriptosGraduadosDTO> obtenerReporteInscriptosGraduadosCarrera(){
        return carreraService.obtenerReporteInscriptosGraduadosCarrera();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carrera> actualizarCarrera(@PathVariable Long id, @RequestBody Carrera carrera) {
        Carrera carreraActualizada = carreraService.actualizarCarrera(id, carrera);
        return ResponseEntity.ok(carreraActualizada);
    }

    @GetMapping
    public List<Carrera> getAllCarreras() {
        return carreraService.getAllCarreras();
    }

    @PostMapping("/crear")
    public ResponseEntity<Carrera> addCarrera(@RequestBody Carrera carrera) throws URISyntaxException {
        carreraService.save(Carrera.builder()
                .nombre(carrera.getNombre())
                .id(carrera.getId()).build());
        return ResponseEntity.created(new URI("/carreras/crear")).build();
    }

}
