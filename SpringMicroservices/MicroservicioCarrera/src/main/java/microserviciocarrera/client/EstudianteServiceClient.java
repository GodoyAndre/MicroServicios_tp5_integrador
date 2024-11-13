package microserviciocarrera.client;

import microserviciocarrera.dto.CarreraInscriptosDTO;
import microserviciocarrera.dto.EstudianteDTO;
import microserviciocarrera.dto.InscriptosCountDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "microservice-estudiante", url = "localhost:8090/estudiantes") //nombre del microservice al que vamos a consultar y , url = "http://localhost:8081") // Cambia la URL y el nombre del servicio si es necesario
public interface EstudianteServiceClient {
    @GetMapping("/cantidad-inscriptos")
    List<InscriptosCountDTO> obtenerCantidadInscriptos();

    @GetMapping("/reporte-estudiantes")
    public List<EstudianteDTO> findEstudianteInscriptoGraduado();
}


