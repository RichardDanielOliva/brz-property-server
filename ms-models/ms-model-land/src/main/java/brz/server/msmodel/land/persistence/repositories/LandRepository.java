package brz.server.msmodel.land.persistence.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import brz.server.msmodel.land.persistence.entities.Land;

@RepositoryRestResource(path = "lands")
public interface LandRepository extends MongoRepository<Land, String> {
}