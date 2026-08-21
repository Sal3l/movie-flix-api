package dev.sal3l.movieflixapi.service;

import dev.sal3l.movieflixapi.entity.User;
import dev.sal3l.movieflixapi.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User create(User user) {
        return repository.save(user);
    }
}
