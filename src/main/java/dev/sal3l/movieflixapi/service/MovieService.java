package dev.sal3l.movieflixapi.service;

import dev.sal3l.movieflixapi.assembler.MovieAssembler;
import dev.sal3l.movieflixapi.entity.Movie;
import dev.sal3l.movieflixapi.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository repository;
    private final MovieAssembler assembler;

    public MovieService(MovieRepository repository, MovieAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    public List<Movie> findAll() {
        return repository.findAll();
    }

    public Movie findById(Long id) {
        Optional<Movie> movie = repository.findById(id);
        return movie.orElse(null);
    }

    public Movie create(Movie movie) {
        Movie prepared = assembler.prepare(movie);
        return repository.save(prepared);
    }

    public Movie UpdateById(Long id, Movie movie) {
        return repository.findById(id)
                .map(existing -> {
                    Movie prepared = assembler.prepare(movie);
                    prepared.setId(id);
                    return repository.save(prepared);
                })
                .orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
