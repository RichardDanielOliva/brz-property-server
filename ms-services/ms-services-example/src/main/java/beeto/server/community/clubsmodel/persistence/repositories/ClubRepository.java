package beeto.server.community.clubsmodel.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import beeto.server.community.clubsmodel.persistence.entities.Club;

@Repository
public interface ClubRepository extends MongoRepository<Club, String> {

}