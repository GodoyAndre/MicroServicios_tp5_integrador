package microservicio_estudiante.tp5_integrador.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteCarreraDTO {

    private String nombres;
    private String apellido;
    private String ciudadResidencia;
    private String nombreCarrera;

    @Override
    public String toString() {
        return "EstudianteCarreraDTO{" +
                "nombres='" + nombres + '\'' +
                ", apellido='" + apellido + '\'' +
                ", ciudadResidencia='" + ciudadResidencia + '\'' +
                ", nombreCarrera='" + nombreCarrera + '\'' +
                '}';
    }
}
