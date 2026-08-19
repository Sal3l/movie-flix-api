package dev.sal3l.movieflixapi.DTO;

import lombok.Builder;

@Builder
public record StreamingResponse(Long id, String name) {
}
