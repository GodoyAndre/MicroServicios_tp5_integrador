package microserviciocarrera.service;

import microserviciocarrera.evento.CarreraActualizadaEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarreraEventPublisher {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void publishCarreraActualizada(Long idCarreraAntiguo, Long idCarreraNuevo) {
        CarreraActualizadaEvent event = new CarreraActualizadaEvent(idCarreraAntiguo, idCarreraNuevo);
        rabbitTemplate.convertAndSend("carreras.exchange", "carrera.actualizada", event);
    }

}

