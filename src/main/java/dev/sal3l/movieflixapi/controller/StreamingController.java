package dev.sal3l.movieflixapi.controller;

import dev.sal3l.movieflixapi.DTO.StreamingRequest;
import dev.sal3l.movieflixapi.DTO.StreamingResponse;
import dev.sal3l.movieflixapi.entity.Streaming;
import dev.sal3l.movieflixapi.mapper.StreamingMapper;
import dev.sal3l.movieflixapi.service.StreamingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/streaming")
public class StreamingController {

    private final StreamingService service;
    private final StreamingMapper mapper;

    public StreamingController(StreamingService service, StreamingMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/")
    public List<StreamingResponse> findAll() {
        List<Streaming> streaminglist = service.findAll();
        return streaminglist.stream().map(mapper::map).toList();
    }

    @GetMapping("/{id}")
    public StreamingResponse findById(@PathVariable Long id) {
        Streaming entity = service.findById(id);
        return mapper.map(entity);
    }

    @PostMapping
    public StreamingResponse create(@RequestBody StreamingRequest request) {
        Streaming entity = mapper.map(request);
        Streaming created = service.create(entity);
        return mapper.map(created);
    }

    @PutMapping("/{id}")
    public StreamingResponse updateById(@PathVariable Long id, @RequestBody StreamingRequest request) {
        Streaming entity = mapper.map(request);
        Streaming updated = service.updateById(id, entity);
        return mapper.map(updated);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.delete(id);
    }
}
