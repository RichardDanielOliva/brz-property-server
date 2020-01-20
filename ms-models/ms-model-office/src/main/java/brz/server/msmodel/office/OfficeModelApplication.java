package brz.server.msmodel.office;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.brz.commons.models.entities.property.Advertiser;
import com.brz.commons.models.entities.property.Location;

import brz.server.msmodel.office.persistence.entities.BuildingAge;
import brz.server.msmodel.office.persistence.entities.EnergyCertificate;
import brz.server.msmodel.office.persistence.entities.Extra;
import brz.server.msmodel.office.persistence.entities.Office;
import brz.server.msmodel.office.persistence.entities.Status;
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
		newHome.setComment("This is a comment");
		newHome.setEnergyCertificate(EnergyCertificate.B);
		newHome.setExtras(Arrays.asList(Extra.PARKING, Extra.WIFI));
		newHome.setStatus(Status.NEW_OFFICE);

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
		
		//officesRepository.save(newHome);
	}
}
