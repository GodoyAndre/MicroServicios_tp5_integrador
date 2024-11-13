package microservicio_estudiante.tp5_integrador.dto;

import java.time.LocalDate;

public class EstudianteInscriptoGraduadoDTO {
    private String numeroLibreta;
    private String nombres;
    private String apellidos;
    private Boolean graduado;
    private Long idCarrera;

    public Long getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Long idCarrera) {
        this.idCarrera = idCarrera;
    }

    public EstudianteInscriptoGraduadoDTO(String numeroLibreta, Boolean graduado, LocalDate fechaInscripcion, String apellidos, String nombres, Long idCarrera) {
        this.numeroLibreta = numeroLibreta;
        this.graduado = graduado;
        this.fechaInscripcion = fechaInscripcion;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.idCarrera = idCarrera;
    }

    private LocalDate fechaInscripcion;

    public String getNumeroLibreta() {
        return numeroLibreta;
    }

    public void setNumeroLibreta(String numeroLibreta) {
        this.numeroLibreta = numeroLibreta;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public Boolean getGraduado() {
        return graduado;
    }

    public void setGraduado(Boolean graduado) {
        this.graduado = graduado;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
}
