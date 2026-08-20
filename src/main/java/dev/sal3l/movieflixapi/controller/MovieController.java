package dev.sal3l.movieflixapi.controller;

import dev.sal3l.movieflixapi.DTO.MovieRequest;
import dev.sal3l.movieflixapi.DTO.MovieResponse;
import dev.sal3l.movieflixapi.entity.Movie;
import dev.sal3l.movieflixapi.mapper.MovieMapper;
import dev.sal3l.movieflixapi.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService service;
    private final MovieMapper mapper;

    public MovieController(MovieService service, MovieMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/")
    public List<MovieResponse> findAll() {
        List<Movie> movies = service.findAll();
        return movies.stream()
                .map(mapper::map)
                .toList();
    }

    @GetMapping("/{id}")
    public MovieResponse findById(@PathVariable Long id) {
        Movie movie = service.findById(id);
        return mapper.map(movie);
    }

    @PostMapping("/")
    public MovieResponse create(@RequestBody MovieRequest request) {
        Movie entity = mapper.map(request);
        Movie created = service.create(entity);
        return mapper.map(created);
    }

    @PutMapping("/{id}")
    public MovieResponse updateById(@PathVariable Long id, @RequestBody MovieRequest request) {
        Movie entity = mapper.map(request);
        Movie updated = service.UpdateById(id, entity);
        return mapper.map(updated);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.delete(id);
    }
}
