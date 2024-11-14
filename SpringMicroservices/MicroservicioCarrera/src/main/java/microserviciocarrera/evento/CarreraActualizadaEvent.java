package microserviciocarrera.evento;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//evento para indicar q una carrera fue actualizada
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarreraActualizadaEvent {
    private Long idCarreraAntiguo;
    private Long idCarreraNuevo;

}
