package dev.sal3l.movieflixapi.service;

import dev.sal3l.movieflixapi.entity.Streaming;
import dev.sal3l.movieflixapi.repository.StreamingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StreamingService {

    private final StreamingRepository repository;

    public StreamingService(StreamingRepository repository) {
        this.repository = repository;
    }

    public List<Streaming> findAll() {
        return repository.findAll();
    }

    public List<Streaming> findAllById(List<Long> streamingIds) {
        return repository.findAllById(streamingIds);
    }

    public Streaming create(Streaming streaming) {
        return repository.save(streaming);
    }

    public Streaming findById(Long id) {
        Optional<Streaming> Streaming = repository.findById(id);
        return Streaming.orElse(null);
    }

    public Streaming updateById(Long id, Streaming streaming) {
        return repository.findById(id)
                .map(existing -> {
                    streaming.setId(id);
                    return repository.save(streaming);
                })
                .orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
