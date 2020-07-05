package brz.server.msmodel.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.geo.GeoJsonModule;

import brz.server.msmodel.home.persistence.repositories.HomesRepository;

@EnableEurekaClient
@SpringBootApplication
public class HomeModelApplication implements CommandLineRunner {
	@Autowired
	HomesRepository homesRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(HomeModelApplication.class, args);
	}
	
	@Bean
	public GeoJsonModule geoJsonModule() {
	    return new GeoJsonModule();
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
