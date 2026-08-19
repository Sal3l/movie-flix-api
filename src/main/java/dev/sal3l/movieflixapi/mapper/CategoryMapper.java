package dev.sal3l.movieflixapi.mapper;

import dev.sal3l.movieflixapi.DTO.CategoryRequest;
import dev.sal3l.movieflixapi.DTO.CategoryResponse;
import dev.sal3l.movieflixapi.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category map(CategoryRequest request) {
        return Category
                .builder()
                .name(request.name())
                .build();
    }

    public CategoryResponse map(Category category) {
        return CategoryResponse
                .builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
