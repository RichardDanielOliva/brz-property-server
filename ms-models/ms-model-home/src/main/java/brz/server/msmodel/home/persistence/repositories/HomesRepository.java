package brz.server.msmodel.home.persistence.repositories;

import java.util.List;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import brz.server.msmodel.home.persistence.entities.Home;

@RepositoryRestResource(path = "")
public interface HomesRepository extends MongoRepository<Home, String> {
	
	List<Home> findByGeometryNear(Point location, Distance distance);
}