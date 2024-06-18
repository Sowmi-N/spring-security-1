package spring.boot.security_4.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.boot.security_4.entity.User;
import spring.boot.security_4.service.UserService;

@RestController
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/user/read")
    public ResponseEntity<User> readUser(@RequestParam Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.readUser(id));
    }
    @PostMapping("/user/create")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        userService.createUser(user);
        return ResponseEntity.status(HttpStatus.OK).body("Created User Successfully");
    }
    @DeleteMapping("/user/delete")
    public ResponseEntity<?> deleteUser(@RequestParam Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("Created Deleted Successfully");
    }
}
