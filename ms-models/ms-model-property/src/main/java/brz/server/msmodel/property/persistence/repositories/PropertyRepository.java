package brz.server.msmodel.property.persistence.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import brz.server.msmodel.property.persistence.entities.Property;

@RepositoryRestResource(path = "properties")
public interface PropertyRepository extends MongoRepository<Property, String> {
}