package dev.sal3l.movieflixapi.mapper;

import dev.sal3l.movieflixapi.DTO.CategoryRequest;
import dev.sal3l.movieflixapi.DTO.CategoryResponse;
import dev.sal3l.movieflixapi.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category map(CategoryRequest request);

    CategoryResponse map(Category category);

}
