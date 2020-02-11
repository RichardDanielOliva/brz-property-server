package brz.server.msmodel.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import brz.server.msmodel.home.persistence.repositories.HomesRepository;

@EnableEurekaClient
@SpringBootApplication
public class HomeModelApplication implements CommandLineRunner {
	@Autowired
	HomesRepository homesRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(HomeModelApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
