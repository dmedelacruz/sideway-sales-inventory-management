package com.sideway.management.resolver.type;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.sideway.management.model.Category;
import com.sideway.management.model.Type;
import com.sideway.management.repository.CategoryRepository;
import com.sideway.management.repository.CategoryTypeRepository;
import com.sideway.management.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryResolver implements GraphQLResolver<Category> {

    private final TypeRepository typeRepository;
    private final CategoryTypeRepository categoryTypeRepository;

    public List<Type> getTypes(Category category) {
        final val categoryTypes = categoryTypeRepository.findAllByCategory_Id(category.getId());
        if(categoryTypes != null && !categoryTypes.isEmpty()) {
            final val typeIds = categoryTypes.stream().map(t -> t.getType().getId()).collect(Collectors.toList());
            return typeRepository.findAllByIdIn(typeIds);
        } else {
            return Collections.emptyList();
        }
    }

}
