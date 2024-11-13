package microservicio_estudiante.tp5_integrador.entity;


import jakarta.persistence.*;
import java.time.LocalDate;

@Embeddable
public class Matricula {
    private Long idCarrera;
    private LocalDate fechaInscripcion; // años de estudio
    private Boolean graduado; // true si está graduado

    //Construtor
    public Matricula() {
    }

    public Matricula(Long idCarrera) {
        this.graduado = false;
        this.fechaInscripcion = LocalDate.now();
        this.idCarrera = idCarrera;
    }

    // Getters y setters
    public Boolean getGraduado() {
        return graduado;
    }

    public void setGraduado(Boolean graduado) {
        this.graduado = graduado;
    }

    public LocalDate getInscripcion() {
        return fechaInscripcion;
    }

    public void setInscripcion(LocalDate inscripcion) {
        this.fechaInscripcion = inscripcion;
    }

    public Long getIdCarrera() {
        return idCarrera;
    }

    public void setCarrera(Long idCarrera) {
        this.idCarrera = idCarrera;
    }

    @Override //acomodar
    public String toString() {
        return "Matricula{" +
                ", carrera=" + idCarrera +
                ", fechaInscripcion=" + fechaInscripcion +
                ", graduado=" + graduado +
                '}';
    }
}

