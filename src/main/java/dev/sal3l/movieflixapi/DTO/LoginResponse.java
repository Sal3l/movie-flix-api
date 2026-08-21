package dev.sal3l.movieflixapi.DTO;

import lombok.Builder;

@Builder
public record LoginResponse(String token) {
}
