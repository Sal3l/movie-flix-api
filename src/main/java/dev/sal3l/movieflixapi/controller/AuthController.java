package dev.sal3l.movieflixapi.controller;

import dev.sal3l.movieflixapi.DTO.LoginRequest;
import dev.sal3l.movieflixapi.DTO.LoginResponse;
import dev.sal3l.movieflixapi.DTO.UserRequest;
import dev.sal3l.movieflixapi.DTO.UserResponse;
import dev.sal3l.movieflixapi.config.TokenService;
import dev.sal3l.movieflixapi.entity.User;
import dev.sal3l.movieflixapi.mapper.UserMapper;
import dev.sal3l.movieflixapi.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AuthController(UserService userService, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping("/register")
    public UserResponse register(@RequestBody UserRequest request) {
        User entity = UserMapper.map(request);
        User created = userService.create(entity);
        return UserMapper.map(created);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(request.email(), request.password());
        Authentication authenticate = authenticationManager.authenticate(userAndPass);

        User user = (User) authenticate.getPrincipal();
        String token = tokenService.generateToken(user);

        return new LoginResponse(token);
    }
}
