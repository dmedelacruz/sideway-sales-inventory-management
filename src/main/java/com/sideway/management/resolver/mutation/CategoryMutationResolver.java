package com.sideway.management.resolver.mutation;

import com.sideway.management.model.Category;
import com.sideway.management.model.Type;
import com.sideway.management.model.junctions.CategoryType;
import com.sideway.management.repository.CategoryRepository;
import com.sideway.management.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryMutationResolver extends MutationResolver{

    private final CategoryRepository categoryRepository;
    private final TypeRepository typeRepository;

    public Category newCategory(String code, String name, List<String> typeIds) {

        Category category = new Category();
        category.setCode(code);
        category.setName(name);

        List<CategoryType> categoryTypes = new ArrayList<>();
        category.setTypes(categoryTypes);
        if(typeIds != null && !typeIds.isEmpty()) {
            final val types = typeRepository.findAllByIdIn(typeIds);
            for (Type type : types) {
                CategoryType categoryType = new CategoryType(category, type);
                categoryTypes.add(categoryType);
            }
        }

        final val categoryEntity = categoryRepository.save(category);
        return categoryEntity;
    }

}
