package brz.server.msmodel.property;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PropertyModelApplication {
	public static void main(String[] args) {
		SpringApplication.run(PropertyModelApplication.class, args);
	}
}
