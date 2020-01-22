package brz.server.msmodel.premise;

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

import brz.server.msmodel.premise.persistence.entities.Extra;
import brz.server.msmodel.premise.persistence.entities.Premise;
import brz.server.msmodel.premise.persistence.repositories.PremiseRepository;

@EnableEurekaClient
@SpringBootApplication
public class PromiseModelApplication implements CommandLineRunner {
	@Autowired
	PremiseRepository promiseRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(PromiseModelApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Premise newPromise = new Premise();
		newPromise.setArea(500.45f);
		newPromise.setBaths(8);
		newPromise.setBuildingAge(BuildingAge.BETWEEN_1961_1970);
		newPromise.setBuildingArea(150.45);
		newPromise.setComment("This is a comment");
		newPromise.setEnergyCertificate(EnergyCertificate.B);
		newPromise.setExtras(Arrays.asList(Extra.AIR_CONDITIONING, Extra.SMOKE_VENT));
		newPromise.setStatus(State.NEW_PROMISE);

		Location location = new Location();
		location.setCity("A Coruna");
		location.setCountry("Spain");
		location.setPostalCode("15758");
		location.setState("Galicia");
		newPromise.setLocation(location);
		
		Advertiser advertiser = new Advertiser();
		advertiser.setPropertyMessage("Good property");
		advertiser.setType("user");
		newPromise.setAdvertiser(advertiser);
		
		//promiseRepository.save(newPromise);
	}
}
