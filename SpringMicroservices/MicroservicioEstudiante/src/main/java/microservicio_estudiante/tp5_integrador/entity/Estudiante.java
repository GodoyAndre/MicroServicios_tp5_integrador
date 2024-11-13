package microservicio_estudiante.tp5_integrador.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Estudiante {

    @Id
    @Column(name = "numero_libreta_universitaria")
    private String numeroLibretaUniversitaria;

    private String nombres;
    private String apellido;
    private Integer edad;
    private String genero;
    private String documento;

    @Column(name = "ciudad_residencia")
    private String ciudadResidencia;

    @ElementCollection
    @CollectionTable(name = "matricula", joinColumns = @JoinColumn(name = "estudiante_id"))
    private List<Matricula> matriculas;

    @Override
    public String toString() {
        return "Estudiante{" +
                "numeroLibretaUniversitaria=" + numeroLibretaUniversitaria +
                ", nombres='" + nombres + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", genero='" + genero + '\'' +
                ", documento='" + documento + '\'' +
                ", ciudadResidencia='" + ciudadResidencia + '\'' +
                '}';
    }
}

