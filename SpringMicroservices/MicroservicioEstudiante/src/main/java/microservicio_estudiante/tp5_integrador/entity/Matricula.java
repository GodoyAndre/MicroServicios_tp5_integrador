package microservicio_estudiante.tp5_integrador.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Matricula {

    private Long idCarrera;
    private LocalDate fechaInscripcion; // años de estudio
    private Boolean graduado; // true si está graduado

    @Override //acomodar
    public String toString() {
        return "Matricula{" +
                ", carrera=" + idCarrera +
                ", fechaInscripcion=" + fechaInscripcion +
                ", graduado=" + graduado +
                '}';
    }
}

