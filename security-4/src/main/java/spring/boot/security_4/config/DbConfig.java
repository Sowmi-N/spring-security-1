package spring.boot.security_4.config;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import spring.boot.security_4.entity.Role;
import spring.boot.security_4.entity.User;
import spring.boot.security_4.repository.RoleRepository;
import spring.boot.security_4.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Component
public class DbConfig {
    private final RoleRepository roleRepository;
    private final UserService userService;
    public DbConfig(RoleRepository roleRepository, UserService userService) {
        this.roleRepository = roleRepository;
        this.userService = userService;
    }
    @PostConstruct
    public void insertRoles() {
        if(!roleRepository.existsById(1)) {
            Role role_user = new Role(1, "ROLE_USER");
            Role role_admin = new Role(2, "ROLE_ADMIN");
            Role read = new Role(3, "read");
            Role write = new Role(4, "write");
            roleRepository.save(role_user);
            roleRepository.save(role_admin);
            roleRepository.save(read);
            roleRepository.save(write);

            // Create a default user so we can login
            if(userService.readUser(1) == null) {
                User user = new User();
                user.setName("user");
                user.setEmail("user@default.com");
                user.setPassword("pass");
                List<Role> roles = new ArrayList<>();
                roles.add(role_admin);
                roles.add(role_user);
                roles.add(read);
                roles.add(write);
                user.setRoles(roles);
                userService.createUser(user);
            }
        }
    }
}
