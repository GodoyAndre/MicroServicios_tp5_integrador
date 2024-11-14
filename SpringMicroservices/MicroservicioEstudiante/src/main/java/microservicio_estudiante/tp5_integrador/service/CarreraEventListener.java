package microservicio_estudiante.tp5_integrador.service;

import microservicio_estudiante.tp5_integrador.entity.Estudiante;
import microservicio_estudiante.tp5_integrador.entity.Matricula;
import microservicio_estudiante.tp5_integrador.event.CarreraActualizadaEvent;
import microservicio_estudiante.tp5_integrador.repository.EstudianteRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarreraEventListener {
    @Autowired
    private IServiceEstudiante estudianteService;

    @RabbitListener(queues = "carrera.actualizada.queue")
    public void handleCarreraActualizada(CarreraActualizadaEvent event) {
        Long idCarreraAntiguo = event.getIdCarreraAntiguo();
        Long idCarreraNuevo = event.getIdCarreraNuevo();
        System.out.println("Evento recibido: " + event);
        // Actualiza el idCarrera en los estudiantes vinculados
        estudianteService.actualizarCarreraEstudiantes(idCarreraAntiguo, idCarreraNuevo);

    }
}
