package brz.server.msmodel.office;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class OfficeModelApplication {
	public static void main(String[] args) {
		SpringApplication.run(OfficeModelApplication.class, args);
	}

}
