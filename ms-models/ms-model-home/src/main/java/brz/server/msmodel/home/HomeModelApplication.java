package brz.server.msmodel.home;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.brz.commons.models.entities.property.Advertiser;
import com.brz.commons.models.entities.property.BuildingAge;
import com.brz.commons.models.entities.property.EnergyCertificate;
import com.brz.commons.models.entities.property.Location;
import com.brz.commons.models.entities.property.Operation;
import com.brz.commons.models.entities.property.State;
import com.brz.commons.models.entities.property.UserContact;
import com.brz.commons.models.entities.property.UserRole;

import brz.server.msmodel.home.persistence.entities.Extra;
import brz.server.msmodel.home.persistence.entities.Home;
import brz.server.msmodel.home.persistence.entities.Type;
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
		newHome.setEnergyCertificate(EnergyCertificate.B);
		newHome.setExtras(Arrays.asList(Extra.HEATING, Extra.PARKING, Extra.SWIMMING_POOL));
		newHome.setRooms(2);
		newHome.setType(Type.APARTMENT);
		newHome.setStatus(State.NEW_HOME);

		Location location = new Location();
		location.setAddressed("Av de Lugo, 227");
		location.setCity("Santiago de Compostela");
		location.setCountry("Spain");
		location.setPostalCode("15703");
		location.setState("Galicia");
		newHome.setLocation(location);
		
		Advertiser advertiser = new Advertiser();
		advertiser.setUserId("0");
		advertiser.setUserRole(UserRole.USER);
		advertiser.setPropertyMessage("Excelent property");
		advertiser.setOperation(Operation.BUY);
		advertiser.setPublishDate(new Date());
		advertiser.setPrice(500000f);
		UserContact contactUser = new UserContact();
		contactUser.setPhones(Arrays.asList("12345678", "87654321"));
		contactUser.setEmails(Arrays.asList("example@example.com", "example2@example.com"));
		advertiser.setUserContact(contactUser);
		newHome.setAdvertiser(advertiser);
		
		//homesRepository.save(newHome);
	}
}
