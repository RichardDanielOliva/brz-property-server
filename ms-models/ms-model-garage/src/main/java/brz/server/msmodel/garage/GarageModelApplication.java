package brz.server.msmodel.garage;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.brz.commons.models.entities.property.Advertiser;
import com.brz.commons.models.entities.property.Location;
import com.brz.commons.models.entities.property.Operation;
import com.brz.commons.models.entities.property.State;
import com.brz.commons.models.entities.property.UserContact;
import com.brz.commons.models.entities.property.UserRole;

import brz.server.msmodel.garage.persistence.entities.Extra;
import brz.server.msmodel.garage.persistence.entities.Garage;
import brz.server.msmodel.garage.persistence.repositories.GarageRepository;

@EnableEurekaClient
@SpringBootApplication
public class GarageModelApplication implements CommandLineRunner {
	@Autowired
	GarageRepository garageRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(GarageModelApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Garage newGarage = new Garage();
		newGarage.setArea(10.45f);

		newGarage.setExtras(Arrays.asList(Extra.POWER_DOOR));
		newGarage.setStatus(State.NEW_GARAGE);

		Location location = new Location();
		location.setAddressed("Av de Lugo, 227");
		location.setCity("A Coruna");
		location.setCountry("Spain");
		location.setPostalCode("15708");
		location.setState("Galicia");
		newGarage.setLocation(location);
		
		Advertiser advertiser = new Advertiser();
		advertiser.setUserId("0");
		advertiser.setUserRole(UserRole.USER);
		advertiser.setPropertyMessage("Excelent garages");
		advertiser.setOperation(Operation.BUY);
		advertiser.setPublishDate(new Date());
		advertiser.setPrice(2000000f);
		UserContact contactUser = new UserContact();
		contactUser.setPhones(Arrays.asList("12345678", "87654321"));
		contactUser.setEmails(Arrays.asList("example@example.com", "example2@example.com"));
		advertiser.setUserContact(contactUser);
		newGarage.setAdvertiser(advertiser);
		
		garageRepository.save(newGarage);
	}
}
