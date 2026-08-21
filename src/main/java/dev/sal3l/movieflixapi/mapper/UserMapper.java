package dev.sal3l.movieflixapi.mapper;

import dev.sal3l.movieflixapi.DTO.UserRequest;
import dev.sal3l.movieflixapi.DTO.UserResponse;
import dev.sal3l.movieflixapi.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static User map(UserRequest request) {
        return User.builder()
                .name(request.name())
                .email(request.email())
                .password(request.password())
                .build();
    }

    public static UserResponse map(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
