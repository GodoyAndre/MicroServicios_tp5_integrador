package microserviciocarrera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MicroservicioCarreraApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioCarreraApplication.class, args);
	}

}
