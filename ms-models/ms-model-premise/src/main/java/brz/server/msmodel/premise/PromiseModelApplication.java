package brz.server.msmodel.premise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class PromiseModelApplication {
	public static void main(String[] args) {
		SpringApplication.run(PromiseModelApplication.class, args);
	}
}
