package spring.boot.security_4.repository;

import org.springframework.data.repository.CrudRepository;
import spring.boot.security_4.entity.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {
}
