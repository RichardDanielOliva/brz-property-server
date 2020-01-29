package brz.server.msmodel.office;

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

import brz.server.msmodel.office.persistence.entities.Extra;
import brz.server.msmodel.office.persistence.entities.Office;
import brz.server.msmodel.office.persistence.repositories.OfficeRepository;

@EnableEurekaClient
@SpringBootApplication
public class OfficeModelApplication implements CommandLineRunner {
	@Autowired
	OfficeRepository officesRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(OfficeModelApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Office newHome = new Office();
		newHome.setArea(500.45f);
		newHome.setBaths(8);
		newHome.setBuildingAge(BuildingAge.BETWEEN_2001_2010);
		newHome.setBuildingArea(150.45);
		newHome.setEnergyCertificate(EnergyCertificate.B);
		newHome.setExtras(Arrays.asList(Extra.PARKING, Extra.WIFI));
		newHome.setStatus(State.NEW_OFFICE);

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
		
		//officesRepository.save(newHome);
	}
}
