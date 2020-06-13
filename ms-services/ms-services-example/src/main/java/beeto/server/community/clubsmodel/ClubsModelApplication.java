package beeto.server.community.clubsmodel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ClubsModelApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClubsModelApplication.class, args);
	}

}
