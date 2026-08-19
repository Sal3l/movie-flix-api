package dev.sal3l.movieflixapi.mapper;

import dev.sal3l.movieflixapi.DTO.CategoryResponse;
import dev.sal3l.movieflixapi.DTO.MovieRequest;
import dev.sal3l.movieflixapi.DTO.MovieResponse;
import dev.sal3l.movieflixapi.DTO.StreamingResponse;
import dev.sal3l.movieflixapi.entity.Category;
import dev.sal3l.movieflixapi.entity.Movie;
import dev.sal3l.movieflixapi.entity.Streaming;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieMapper {

    public static Movie map(MovieRequest request) {

        List<Category> categories = request.categories().stream()
                .map(categoryId -> Category.builder().id(categoryId).build())
                .toList();

        List<Streaming> streamings = request.streamings().stream()
                .map(streamingId -> Streaming.builder().id(streamingId).build())
                .toList();

        return Movie
                .builder()
                .title(request.title())
                .description(request.description())
                .releaseDate(request.releaseDate())
                .rating(request.rating())
                .categories(categories)
                .streamings(streamings)
                .build();
    }
    
    public static MovieResponse map(Movie movie) {

        List<CategoryResponse> categories = movie.getCategories()
                .stream()
                .map(CategoryMapper::map)
                .toList();

        List<StreamingResponse> streamings = movie.getStreamings()
                .stream()
                .map(StreamingMapper::map)
                .toList();

        return MovieResponse.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .description(movie.getDescription())
                .releaseDate(movie.getReleaseDate())
                .rating(movie.getRating())
                .categories(categories)
                .streamings(streamings)
                .build();
    }
}
