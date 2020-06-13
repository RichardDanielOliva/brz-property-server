package brz.server.msmodel.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class GroupsModelApplication {
	public static void main(String[] args) {
		SpringApplication.run(GroupsModelApplication.class, args);
	}
}
