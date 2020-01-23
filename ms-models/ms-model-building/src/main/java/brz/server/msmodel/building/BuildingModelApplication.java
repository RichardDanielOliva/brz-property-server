package brz.server.msmodel.building;

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
		newBuilding.setComment("This is a comment");

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
		location.setCity("A Coruna");
		location.setCountry("Spain");
		location.setPostalCode("15708");
		location.setState("Galicia");
		newBuilding.setLocation(location);
		
		Advertiser advertiser = new Advertiser();
		advertiser.setPropertyMessage("Excelent property");
		advertiser.setType("user");
		newBuilding.setAdvertiser(advertiser);
		
		officesRepository.save(newBuilding);
	}
}
