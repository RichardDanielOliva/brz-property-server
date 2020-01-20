package brz.server.msmodel.home;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.brz.commons.models.entities.property.Advertiser;
import com.brz.commons.models.entities.property.Location;

import brz.server.msmodel.home.persistence.entities.BuildingAge;
import brz.server.msmodel.home.persistence.entities.EnergyCertificate;
import brz.server.msmodel.home.persistence.entities.Extra;
import brz.server.msmodel.home.persistence.entities.Home;
import brz.server.msmodel.home.persistence.entities.Status;
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
		Home newHome = new Home();
		newHome.setArea(220.45f);
		newHome.setBaths(2);
		newHome.setBuildingAge(BuildingAge.BETWEEN_1951_1960);
		newHome.setBuildingArea(150.45);
		newHome.setComment("This is a comment");
		newHome.setEnergyCertificate(EnergyCertificate.B);
		newHome.setExtras(Arrays.asList(Extra.HEATING, Extra.PARKING, Extra.SWIMMING_POOL));
		newHome.setRooms(2);
		newHome.setStatus(Status.NEW_HOME);

		Location location = new Location();
		location.setCity("Santiago de Compostela");
		location.setCountry("Spain");
		location.setPostalCode("15703");
		location.setState("Galicia");
		newHome.setLocation(location);
		
		Advertiser advertiser = new Advertiser();
		advertiser.setPropertyMessage("Excelent property");
		advertiser.setType("user");
		newHome.setAdvertiser(advertiser);
		
		//homesRepository.save(newHome);
	}
}
