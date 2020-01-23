package brv.ms.models.user.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.brz.commons.models.entities.user.User;

@RepositoryRestResource(path="users")
public interface UserRepository extends JpaRepository<User, Long> {
	@RestResource(path="findByUsername")
	public User findByUsername(@Param("username") String username);
	
//	@Query("select u from Usuario u where u.username=?1")
//	public User obtenerPorUsername(String username);
}
