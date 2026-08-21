package dev.sal3l.movieflixapi.DTO;

import lombok.Builder;

@Builder
public record UserResponse(Long id,
                           String name,
                           String email
                           ) {
}
