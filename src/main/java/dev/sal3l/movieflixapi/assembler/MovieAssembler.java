package dev.sal3l.movieflixapi.assembler;

import dev.sal3l.movieflixapi.entity.Category;
import dev.sal3l.movieflixapi.entity.Movie;
import dev.sal3l.movieflixapi.entity.Streaming;
import dev.sal3l.movieflixapi.service.CategoryService;
import dev.sal3l.movieflixapi.service.StreamingService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieAssembler {

    private final CategoryService categoryService;
    private final StreamingService streamingService;

    public MovieAssembler(CategoryService categoryService, StreamingService streamingService) {
        this.categoryService = categoryService;
        this.streamingService = streamingService;
    }

    private List<Category> prepareCategory(List<Category> categories) {
        List<Long> ids = categories.stream()
                .map(Category::getId)
                .toList();

        return categoryService.findAllById(ids);
    }

    private List<Streaming> prepareStreaming(List<Streaming> streamings) {
        List<Long> ids = streamings.stream()
                .map(Streaming::getId)
                .toList();

        return streamingService.findAllById(ids);
    }

    public Movie prepare(Movie movie) {
        List<Category> categories = prepareCategory(movie.getCategories());
        List<Streaming> streamings = prepareStreaming(movie.getStreamings());

        movie.setCategories(categories);
        movie.setStreamings(streamings);
        return movie;
    }
}
