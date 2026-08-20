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

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<MovieResponse> findAll() {
        List<Movie> movies = service.findAll();
        return movies.stream()
                .map(MovieMapper::map)
                .toList();
    }

    @GetMapping("/{id}")
    public MovieResponse findById(@PathVariable Long id) {
        Movie movie = service.findById(id);
        return MovieMapper.map(movie);
    }

    @PostMapping("/")
    public MovieResponse create(@RequestBody MovieRequest request) {
        Movie entity = MovieMapper.map(request);
        Movie created = service.create(entity);
        return MovieMapper.map(created);
    }

    @PutMapping("/{id}")
    public MovieResponse updateById(@PathVariable Long id, @RequestBody MovieRequest request) {
        Movie entity = MovieMapper.map(request);
        Movie updated = service.UpdateById(id, entity);
        return MovieMapper.map(updated);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.delete(id);
    }
}
