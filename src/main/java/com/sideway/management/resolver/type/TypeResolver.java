package com.sideway.management.resolver.type;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.sideway.management.model.Brand;
import com.sideway.management.model.Category;
import com.sideway.management.model.Type;
import com.sideway.management.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TypeResolver implements GraphQLResolver<Type> {

    private final BrandRepository brandRepository;
    private final TypeBrandRepository typeBrandRepository;

    private final CategoryRepository categoryRepository;
    private final CategoryTypeRepository categoryTypeRepository;

    public List<Brand> getBrands(Type type) {
        final val typeBrands = typeBrandRepository.findAllByType_Id(type.getId());
        if(typeBrands != null && !typeBrands.isEmpty()) {
            final val brandIds = typeBrands.stream().map(b -> b.getBrand().getId()).collect(Collectors.toList());
            return brandRepository.findAllByIdIn(brandIds);
        } else {
            return Collections.emptyList();
        }
    }

    public List<Category> getCategories(Type type) {
        final val categoryTypes = categoryTypeRepository.findAllByType_Id(type.getId());
        if(categoryTypes != null && !categoryTypes.isEmpty()) {
            final val categoryIds = categoryTypes.stream().map(c -> c.getCategory().getId()).collect(Collectors.toList());
            return categoryRepository.findAllByIdIn(categoryIds);
        } else {
            return Collections.emptyList();
        }
    }

}
