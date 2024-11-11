package microservicio_estudiante.microserviciocarrera.dto;


public class CarreraInscriptosDTO {

    private String nombreCarrera;
    private Long cantInscriptos;

    public CarreraInscriptosDTO(String nombreCarrera, Long cantInscriptos) {
        this.nombreCarrera = nombreCarrera;
        this.cantInscriptos = cantInscriptos;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public Long getCantInscriptos() {
        return cantInscriptos;
    }

    public void setCantInscriptos(Long cantInscriptos) {
        this.cantInscriptos = cantInscriptos;
    }

    @Override
    public String toString() {
        return "CarreraInscriptosDTO{" +
                "nombreCarrera='" + nombreCarrera + '\'' +
                ", cantInscriptos=" + cantInscriptos +
                '}';
    }
}


