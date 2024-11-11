package microservicio_estudiante.microserviciocarrera.dto;

import java.time.LocalDate;

public class EstudiantesInscriptosGraduadosDTO {
    private String nombre;
    private String apellido;
    private String numeroLibretaUniversitaria;
    private String nombreCarrera;
    private String estado;
    private LocalDate anio;

    public EstudiantesInscriptosGraduadosDTO(String nombre, String apellido, String numeroLibretaUniversitaria, String nombreCarrera, Boolean graduado, LocalDate anio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroLibretaUniversitaria = numeroLibretaUniversitaria;
        this.nombreCarrera = nombreCarrera;
        this.estado = graduado ? "Graduado" : "Inscripto";
        this.anio = anio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombres) {
        this.nombre = nombre;
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

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getAnio() {
        return anio;
    }

    public void setAnio(LocalDate anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "EstudianteCarreraDTO{" +
                "nombres='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", numeroLibretaUniversitaria='" + numeroLibretaUniversitaria + '\'' +
                ", nombreCarrera='" + nombreCarrera + '\'' +
                ", estado='" + estado + '\'' +
                ", anio=" + anio.getYear() + '\'' +
                '}';
    }
}
