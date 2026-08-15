package dev.sal3l.movieflixapi.service;

import dev.sal3l.movieflixapi.entity.Category;
import dev.sal3l.movieflixapi.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category create(Category category) {
        return repository.save(category);
    }

    public Category findById(Long id) {
        Optional<Category> category = repository.findById(id);
        return category.orElse(null);
    }

    public Category updateById(Long id, Category category) {
        return repository.findById(id)
                .map(existing -> {
                    category.setId(id);
                    return repository.save(category);
                })
                .orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
