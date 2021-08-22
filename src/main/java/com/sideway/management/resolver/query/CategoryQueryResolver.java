package com.sideway.management.resolver.query;

import com.sideway.management.model.Category;
import com.sideway.management.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryQueryResolver extends QueryResolver {

    private final CategoryRepository categoryRepository;

    public List<Category> findAllCategories(int page, int pageSize) {
        if(page < 1) {
            page = 1;
        }
        return categoryRepository.findAllCategories(page - 1, pageSize);
    }

    public Category findCategoryById(String id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Category findCategoryByCode(String code) {
        return categoryRepository.findByCode(code);
    }

    public List<Category> findCategoriesByName(String name) {
        return categoryRepository.findAllByName(name);
    }

}
