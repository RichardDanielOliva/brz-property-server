package wirtz.project.server.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import wirtz.project.server.persistence.entities.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(String username);
}
