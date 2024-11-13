package microserviciocarrera.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteDTO {
    private String numeroLibreta;
    private String nombres;
    private String apellidos;
    private Boolean graduado;
    private Long idCarrera;
    private LocalDate anio;
}

