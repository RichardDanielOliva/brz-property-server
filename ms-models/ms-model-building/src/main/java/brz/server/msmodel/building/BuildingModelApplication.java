package brz.server.msmodel.building;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.brz.commons.models.entities.property.Advertiser;
import com.brz.commons.models.entities.property.BuildingAge;
import com.brz.commons.models.entities.property.UserContact;
import com.brz.commons.models.entities.property.Location;
import com.brz.commons.models.entities.property.Operation;
import com.brz.commons.models.entities.property.State;
import com.brz.commons.models.entities.property.UserRole;

import brz.server.msmodel.building.persistence.entities.Building;
import brz.server.msmodel.building.persistence.entities.GaragesFeature;
import brz.server.msmodel.building.persistence.entities.HomesFeature;
import brz.server.msmodel.building.persistence.entities.OfficesFeature;
import brz.server.msmodel.building.persistence.entities.PromisesFeature;
import brz.server.msmodel.building.persistence.repositories.BuildingRepository;

@EnableEurekaClient
@SpringBootApplication
public class BuildingModelApplication implements CommandLineRunner {
	@Autowired
	BuildingRepository officesRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BuildingModelApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Building newBuilding = new Building();
		newBuilding.setArea(500.45f);
		newBuilding.setBuildingAge(BuildingAge.BETWEEN_2001_2010);
		newBuilding.setBuildingArea(150.45);

		newBuilding.setStatus(State.NEW_BUILD);
		
		GaragesFeature garagesFeature = new GaragesFeature();
		garagesFeature.setTotalArea(500.23f);
		garagesFeature.setUnits(45);
		newBuilding.setGaragesFeature(garagesFeature);

		HomesFeature homeFeature = new HomesFeature();
		homeFeature.setTotalArea(3000.23f);
		homeFeature.setUnits(24);
		newBuilding.setHomesFeature(homeFeature);
		
		OfficesFeature officesFeature = new OfficesFeature();
		officesFeature.setTotalArea(2500.23f); 
		officesFeature.setUnits(10);
		newBuilding.setOfficesFeature(officesFeature);
		
		PromisesFeature promisesFeature = new PromisesFeature();
		promisesFeature.setTotalArea(2500.23f); 
		promisesFeature.setUnits(10);
		newBuilding.setPromisesFeature(promisesFeature);;
		
		Location location = new Location();
		location.setAddressed("Av de Lugo, 227");
		location.setCity("A Coruna");
		location.setCountry("Spain");
		location.setPostalCode("15708");
		location.setState("Galicia");
		newBuilding.setLocation(location);
		
		Advertiser advertiser = new Advertiser();
		advertiser.setUserId("0");
		advertiser.setUserRole(UserRole.USER);
		advertiser.setPropertyMessage("Excelent property");
		advertiser.setOperation(Operation.BUY);
		advertiser.setPublishDate(new Date());
		advertiser.setPrice(2000000f);
		UserContact contactUser = new UserContact();
		contactUser.setPhones(Arrays.asList("12345678", "87654321"));
		contactUser.setEmails(Arrays.asList("example@example.com", "example2@example.com"));
		advertiser.setUserContact(contactUser);
		newBuilding.setAdvertiser(advertiser);
		
		officesRepository.save(newBuilding);
	}
}
