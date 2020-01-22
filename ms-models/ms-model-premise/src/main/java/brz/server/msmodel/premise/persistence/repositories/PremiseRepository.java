package brz.server.msmodel.premise.persistence.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import brz.server.msmodel.premise.persistence.entities.Premise;

@RepositoryRestResource(path = "premise")
public interface PremiseRepository extends MongoRepository<Premise, String> {
}