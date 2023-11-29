package projectuas.bioskop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import projectuas.bioskop.model.ERole;
import projectuas.bioskop.model.Role;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}
