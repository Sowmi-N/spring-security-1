package spring.boot.security_4.service;

import spring.boot.security_4.entity.User;

public interface UserService {
    void createUser(User user);
    User readUser(int id);
    void deleteUser(int id);
}
