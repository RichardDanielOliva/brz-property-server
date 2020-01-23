package brz.server.msmodel.building.persistence.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import brz.server.msmodel.building.persistence.entities.Building;

@RepositoryRestResource(path = "buildings")
public interface BuildingRepository extends MongoRepository<Building, String> {
}