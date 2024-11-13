package microserviciocarrera.controller;

import microserviciocarrera.dto.CarreraInscriptosDTO;
import microserviciocarrera.entity.Carrera;
import microserviciocarrera.service.ICarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/con-inscriptos")
    public List<CarreraInscriptosDTO> getCarrerasWithInscriptos(){
        return carreraService.obtenerCarrerasConInscriptos();
    }

}
