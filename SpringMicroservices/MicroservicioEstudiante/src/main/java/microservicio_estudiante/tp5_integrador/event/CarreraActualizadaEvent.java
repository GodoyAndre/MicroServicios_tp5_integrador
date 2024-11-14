package microservicio_estudiante.tp5_integrador.event;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//evento para indicar q una carrera fue actualizada
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarreraActualizadaEvent {
    private Long idCarreraAntiguo;
    private Long idCarreraNuevo;


}
