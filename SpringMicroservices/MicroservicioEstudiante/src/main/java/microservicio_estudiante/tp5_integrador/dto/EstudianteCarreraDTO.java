package microservicio_estudiante.tp5_integrador.dto;



public class EstudianteCarreraDTO {

    private String nombres;
    private String apellido;
    private String ciudadResidencia;
    private String nombreCarrera;

    public EstudianteCarreraDTO(String nombres, String apellido, String ciudadResidencia, String nombreCarrera) {
        this.nombres = nombres;
        this.apellido = apellido;
        this.ciudadResidencia = ciudadResidencia;
        this.nombreCarrera = nombreCarrera;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

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
