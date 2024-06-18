package spring.boot.security_4.repository;

import org.springframework.data.repository.CrudRepository;
import spring.boot.security_4.entity.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
