package brv.ms.models.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@EntityScan({"com.brz.commons.models.entities.user"})
@SpringBootApplication(exclude = {
		  MongoAutoConfiguration.class, 
		  MongoDataAutoConfiguration.class
		})
public class MsModelUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsModelUserApplication.class, args);
	}

}
