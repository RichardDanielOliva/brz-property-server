package brz.server.msmodel.premise.persistence.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.brz.commons.models.entities.property.Operation;

import brz.autoconfiguration.library.models.entities.premise.Premise;

@RepositoryRestResource(path = "premises")
public interface PremiseRepository extends MongoRepository<Premise, String> {
	
	@RestResource(path = "findByOperationAndLocation") //http://localhost:55209/premises/search/findByOperationAndLocation?x=42.881574&y=-8.528751&operation=BUY&minDistance=5000
	@Query(value="{ geometry: {   $near: {  $geometry: {  type: 'Point' ,  coordinates: [ ?0 , ?1 ]  }, $maxDistance: ?2 }   }," + 
				 " 'advertiser.operation' : ?3 }")
	List<Premise> findByAdvertiserOperationAndGeometryNear(double x, double y, double minDistance, Operation operation);
}