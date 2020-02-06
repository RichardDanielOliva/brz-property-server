package brz.server.msmodel.office.persistence.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.brz.commons.models.entities.property.Operation;

import brz.server.msmodel.office.persistence.entities.Office;

@RepositoryRestResource(path = "offices")
public interface OfficeRepository extends MongoRepository<Office, String> {
	@RestResource(path = "findByOperationAndLocation") //http://localhost:55209/offices/search/findByOperationAndLocation?x=42.881574&y=-8.528751&operation=BUY&minDistance=5000
	@Query(value="{ geometry: {   $near: {  $geometry: {  type: 'Point' ,  coordinates: [ ?0 , ?1 ]  }, $maxDistance: ?2 }   }," + 
				 " 'advertiser.operation' : ?3 }")
	List<Office> findByAdvertiserOperationAndGeometryNear(double x, double y, double minDistance, Operation operation);
}