package microservicio_estudiante.tp5_integrador.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "MicroservicioCarrera", url = "http://localhost:8080") //nombre del microservice al que vamos a consultar y , url = "http://localhost:8081") // Cambia la URL y el nombre del servicio si es necesario
public interface CarreraClient {
    @GetMapping("/search-ny-student/{idCarrera}")
    String getNombreCarreraById(@PathVariable("idCarrera") Long idCarrera);
}
