package microservicio_estudiante.tp5_integrador.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InscriptosCountDTO {

    private long idCarrera;
    private long cantInscriptos;
}
