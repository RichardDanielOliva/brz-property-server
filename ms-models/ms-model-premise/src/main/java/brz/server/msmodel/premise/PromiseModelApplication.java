package brz.server.msmodel.premise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.geo.GeoJsonModule;


@EnableEurekaClient
@SpringBootApplication
public class PromiseModelApplication {
	public static void main(String[] args) {
		SpringApplication.run(PromiseModelApplication.class, args);
	}
	
	@Bean
	public GeoJsonModule geoJsonModule() {
	    return new GeoJsonModule();
	}
}
