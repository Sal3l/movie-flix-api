package dev.sal3l.movieflixapi.controller;

import dev.sal3l.movieflixapi.DTO.UserRequest;
import dev.sal3l.movieflixapi.DTO.UserResponse;
import dev.sal3l.movieflixapi.entity.User;
import dev.sal3l.movieflixapi.mapper.UserMapper;
import dev.sal3l.movieflixapi.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserResponse register(@RequestBody UserRequest request) {
        User entity = UserMapper.map(request);
        User created = userService.create(entity);
        return UserMapper.map(created);
    }
}
