package microservicio_estudiante.tp5_integrador.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MatriculasDTO {
    private Long matricula;
    private String numeroLibretaUniversitaria;
    private String nombre;
    private String apellido;
    private Long idCarrera;
    private String nombreCarrera;
    private LocalDate fechaInscripcion;
    private String graduado;
}
