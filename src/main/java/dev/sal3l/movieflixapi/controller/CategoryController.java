package dev.sal3l.movieflixapi.controller;

import dev.sal3l.movieflixapi.DTO.CategoryRequest;
import dev.sal3l.movieflixapi.DTO.CategoryResponse;
import dev.sal3l.movieflixapi.entity.Category;
import dev.sal3l.movieflixapi.mapper.CategoryMapper;
import dev.sal3l.movieflixapi.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService service;
    private final CategoryMapper mapper;

    public CategoryController(CategoryService service, CategoryMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/")
    public List<CategoryResponse> findAll() {
        List<Category> categorylist = service.findAll();
        return categorylist.stream().map(mapper::map).toList();
    }

    @GetMapping("/{id}")
    public CategoryResponse findById(@PathVariable Long id) {
        Category entity = service.findById(id);
        return mapper.map(entity);
    }

    @PostMapping
    public CategoryResponse create(@RequestBody CategoryRequest request) {
        Category entity = mapper.map(request);
        Category created = service.create(entity);
        return mapper.map(created);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.delete(id);
    }
}
