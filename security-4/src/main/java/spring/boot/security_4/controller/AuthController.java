package spring.boot.security_4.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.security_4.service.TokenService;

@RestController
public class AuthController {
    private final TokenService tokenService;
    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }
    @GetMapping("/token")
    public String generateToken(Authentication authentication) {
        return tokenService.generateToken(authentication);
    }
}
