package dev.sal3l.movieflixapi.controller;

import dev.sal3l.movieflixapi.DTO.CategoryRequest;
import dev.sal3l.movieflixapi.DTO.CategoryResponse;
import dev.sal3l.movieflixapi.entity.Category;
import dev.sal3l.movieflixapi.mapper.CategoryMapper;
import dev.sal3l.movieflixapi.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<CategoryResponse> findAll() {
        List<Category> categorylist = service.findAll();
        return categorylist.stream().map(CategoryMapper::map).toList();
    }

    @GetMapping("/{id}")
    public CategoryResponse findById(@PathVariable Long id) {
        Category entity = service.findById(id);
        return CategoryMapper.map(entity);
    }

    @PostMapping
    public CategoryResponse create(@RequestBody CategoryRequest request) {
        Category entity = CategoryMapper.map(request);
        Category created = service.create(entity);
        return CategoryMapper.map(created);
    }

    @PutMapping("/{id}")
    public CategoryResponse updateById(@PathVariable Long id, @RequestBody CategoryRequest request) {
        Category entity = CategoryMapper.map(request);
        Category updated = service.updateById(id, entity);
        return CategoryMapper.map(updated);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.delete(id);
    }
}
