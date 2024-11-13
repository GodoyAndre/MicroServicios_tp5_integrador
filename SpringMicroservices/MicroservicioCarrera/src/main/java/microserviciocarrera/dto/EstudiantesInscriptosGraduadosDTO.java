package microserviciocarrera.dto;

import jakarta.persistence.NamedEntityGraph;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstudiantesInscriptosGraduadosDTO {
    private String nombre;
    private String apellido;
    private String numeroLibretaUniversitaria;
    private String nombreCarrera;
    private String estado;
    private int anio;


    @Override
    public String toString() {
        return "EstudianteCarreraDTO{" +
                "nombres='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", numeroLibretaUniversitaria='" + numeroLibretaUniversitaria + '\'' +
                ", nombreCarrera='" + nombreCarrera + '\'' +
                ", estado='" + estado + '\'' +
                ", anio=" + anio + '\'' +
                '}';
    }
}
