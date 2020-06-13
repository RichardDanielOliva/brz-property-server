package brz.server.msmodel.land;

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

		Location location = new Location();
		location.setAddressed("Av de Lugo, 227");
		location.setCity("A Coruna");
		location.setCountry("Spain");
		location.setPostalCode("15708");
		location.setState("Galicia");
		newHome.setLocation(location);
		
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
		newHome.setAdvertiser(advertiser);
		
		newHome.setClassType(ClassType.RURAL);
		newHome.setMainUse(MainLandUse.AGRARIAN);
		
		//landRepository.save(newHome);
	}
}
