package brz.server.msmodel.home.persistence.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import brz.server.msmodel.home.persistence.entities.Home;

@RepositoryRestResource(path = "homes")
public interface HomesRepository extends MongoRepository<Home, String> {
}