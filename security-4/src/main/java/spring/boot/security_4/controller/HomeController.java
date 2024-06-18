package spring.boot.security_4.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@EnableMethodSecurity
public class HomeController {

    @GetMapping("/")
    public ResponseEntity<?> getHome(Principal principal, Authentication authentication) {
        String response = principal.toString() + authentication.toString();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/home/default")
    public String deflt() {
        return "Application is working";
    }

    @GetMapping("/home/principal")
    public String getPrincipal(Principal principal) {
        return "Hello " + principal.getName();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/home/role/admin")
    public String hasAdminRole(Authentication authentication) {
        return "Yes " + authentication.getName() + " has role ADMIN";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/home/role/user")
    public String hasUserRole(Authentication authentication) {
        return "Yes " + authentication.getName() + " has role USER";
    }

    @PreAuthorize("hasAuthority('read')")
    @GetMapping("/home/authority/read")
    public String hasAuthorityRead(Authentication authentication) {
        return "Yes " + authentication.getName() + " has authority read";
    }

    @PreAuthorize("hasAuthority('write')")
    @GetMapping("/home/authority/write")
    public String hasAuthorityWrite(Authentication authentication) {
        return "Yes " + authentication.getName() + " has authority write";
    }
}
