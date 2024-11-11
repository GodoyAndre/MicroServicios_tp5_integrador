package microservicio_estudiante.microserviciocarrera.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    // Constructor
    public Carrera() {
        //super();
    }

    public Carrera(String nombre) {
        //super();
        this.nombre = nombre;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}

