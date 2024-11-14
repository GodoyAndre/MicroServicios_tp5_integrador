package microservicio_estudiante.tp5_integrador.dto;

import lombok.*;

import java.time.LocalDate;


@Setter
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteInscriptoGraduadoDTO {
    private String numeroLibreta;
    private String nombres;
    private String apellidos;
    private Boolean graduado;
    private Long idCarrera;
    private LocalDate anio;
    private LocalDate fechaInscripcion;

    public EstudianteInscriptoGraduadoDTO(String numeroLibreta, Boolean graduado, LocalDate fechaInscripcion, String apellidos, String nombres, Long idCarrera, LocalDate anio) {
        this.numeroLibreta = numeroLibreta;
        this.graduado = graduado;
        this.fechaInscripcion = fechaInscripcion;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.idCarrera = idCarrera;
        this.anio = anio;
    }

}
