package brz.server.msmodel.garage.persistence.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import brz.server.msmodel.garage.persistence.entities.Garage;

@RepositoryRestResource(path = "garages")
public interface GarageRepository extends MongoRepository<Garage, String> {
}