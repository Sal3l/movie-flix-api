package dev.sal3l.movieflixapi.DTO;

import lombok.Builder;

@Builder
public record CategoryRequest (String name) {
}
