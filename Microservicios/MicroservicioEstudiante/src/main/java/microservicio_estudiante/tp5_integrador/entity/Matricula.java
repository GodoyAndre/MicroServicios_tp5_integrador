package microservicio_estudiante.tp5_integrador.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    @JsonIgnore
    private Estudiante estudiante;

    @Column(name = "carrera_id")
    private Long idCarrera;

    @Column(name = "fecha_inscripcion")
    private LocalDate fechaInscripcion; // años de estudio

    private Boolean graduado; // true si está graduado

    //Construtor
    public Matricula() {
    }

    public Matricula(Long idCarrera, Estudiante estudiante) {
        this.graduado = false;
        this.fechaInscripcion = LocalDate.now();
        this.idCarrera = idCarrera;
        this.estudiante = estudiante;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

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

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    @Override //acomodar
    public String toString() {
        return "Matricula{" +
                "id=" + id +
                ", estudiante=" + estudiante +
                ", carrera=" + idCarrera +
                ", fechaInscripcion=" + fechaInscripcion +
                ", graduado=" + graduado +
                '}';
    }
}

