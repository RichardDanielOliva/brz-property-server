package brz.server.msmodel.example.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import brz.server.msmodel.example.persistence.entities.Group;

@RepositoryRestResource(path = "groups")
public interface GroupRepository extends MongoRepository<Group, String> {
	List<Group> findByUserIds(String userId);
}