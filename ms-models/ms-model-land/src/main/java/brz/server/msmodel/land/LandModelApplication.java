package brz.server.msmodel.land;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.brz.commons.models.entities.property.Advertiser;
import com.brz.commons.models.entities.property.BuildingAge;
import com.brz.commons.models.entities.property.EnergyCertificate;
import com.brz.commons.models.entities.property.Location;
import com.brz.commons.models.entities.property.State;

import brz.server.msmodel.land.persistence.entities.ClassType;
import brz.server.msmodel.land.persistence.entities.Land;
import brz.server.msmodel.land.persistence.entities.MainLandUse;
import brz.server.msmodel.land.persistence.repositories.LandRepository;

@EnableEurekaClient
@SpringBootApplication
public class LandModelApplication implements CommandLineRunner {
	@Autowired
	LandRepository landRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(LandModelApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Land newHome = new Land();
		newHome.setArea(500.45f);
	
		newHome.setComment("This is a comment");

		Location location = new Location();
		location.setCity("A Coruna");
		location.setCountry("Spain");
		location.setPostalCode("15708");
		location.setState("Galicia");
		newHome.setLocation(location);
		
		Advertiser advertiser = new Advertiser();
		advertiser.setPropertyMessage("Excelent property");
		advertiser.setType("user");
		newHome.setAdvertiser(advertiser);
		
		newHome.setClassType(ClassType.RURAL);
		newHome.setMainLandUse(MainLandUse.AGRARIAN);
		
		//landRepository.save(newHome);
	}
}
