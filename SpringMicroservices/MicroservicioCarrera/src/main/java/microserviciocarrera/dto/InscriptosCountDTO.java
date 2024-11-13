package microserviciocarrera.dto;

public class InscriptosCountDTO {

    private long idCarrera;
    private long cantInscriptos;

    public InscriptosCountDTO(long idCarrera, long cantInscriptos) {
        this.idCarrera = idCarrera;
        this.cantInscriptos = cantInscriptos;
    }

    // Getters and setters
    public long getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(long idCarrera) {
        this.idCarrera = idCarrera;
    }

    public long getCantInscriptos() {
        return cantInscriptos;
    }

    public void setCantInscriptos(long cantInscriptos) {
        this.cantInscriptos = cantInscriptos;
    }
}
