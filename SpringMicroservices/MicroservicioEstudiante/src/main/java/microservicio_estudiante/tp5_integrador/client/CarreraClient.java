package microservicio_estudiante.tp5_integrador.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservice-carrera", url = "http://localhost:9090/carreras")
public interface CarreraClient {
    @GetMapping("/search-ny-student/{idCarrera}")
    String getNombreCarreraById(@PathVariable("idCarrera") Long idCarrera);
}
