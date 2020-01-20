package brz.server.msmodel.office.persistence.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import brz.server.msmodel.office.persistence.entities.Office;

@RepositoryRestResource(path = "offices")
public interface OfficeRepository extends MongoRepository<Office, String> {
}