package microservicio_estudiante.tp5_integrador.dto;

import java.time.LocalDate;

public class MatriculasDTO {
    private Long matricula;
    private String numeroLibretaUniversitaria;
    private String nombre;
    private String apellido;
    private Long idCarrera;
    private String nombreCarrera;
    private LocalDate fechaInscripcion;
    private String graduado;

    public MatriculasDTO(Long matricula, Boolean graduado, LocalDate fechaInscripcion, String nombreCarrera, Long idCarrera, String apellido, String nombre, String numeroLibretaUniversitaria) {
        this.matricula = matricula;
        this.graduado = graduado ? "Graduado" : "Inscripto";
        this.fechaInscripcion = fechaInscripcion;
        this.nombreCarrera = nombreCarrera;
        this.idCarrera = idCarrera;
        this.apellido = apellido;
        this.nombre = nombre;
        this.numeroLibretaUniversitaria = numeroLibretaUniversitaria;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getGraduado() {
        return graduado;
    }

    public void setGraduado(String graduado) {
        this.graduado = graduado;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public Long getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Long idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumeroLibretaUniversitaria() {
        return numeroLibretaUniversitaria;
    }

    public void setNumeroLibretaUniversitaria(String numeroLibretaUniversitaria) {
        this.numeroLibretaUniversitaria = numeroLibretaUniversitaria;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "MatriculasDTO{" +
                "matricula=" + matricula +
                ", numeroLibretaUniversitaria='" + numeroLibretaUniversitaria + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", idCarrera=" + idCarrera +
                ", nombreCarrera='" + nombreCarrera + '\'' +
                ", fechaInscripcion=" + fechaInscripcion +
                ", graduado='" + graduado + '\'' +
                '}';
    }
}
