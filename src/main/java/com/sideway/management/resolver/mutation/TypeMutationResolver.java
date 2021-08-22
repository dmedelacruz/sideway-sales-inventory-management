package com.sideway.management.resolver.mutation;

import com.sideway.management.model.Brand;
import com.sideway.management.model.Category;
import com.sideway.management.model.Type;
import com.sideway.management.model.junctions.CategoryType;
import com.sideway.management.model.junctions.TypeBrand;
import com.sideway.management.repository.BrandRepository;
import com.sideway.management.repository.CategoryRepository;
import com.sideway.management.repository.TypeBrandRepository;
import com.sideway.management.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeMutationResolver extends MutationResolver{

    private final TypeRepository typeRepository;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;

    public Type newType(
            String code,
            String name,
            String subType,
            List<String> categoryIds,
            List<String> brandIds
    ) {
        Type type = new Type();
        type.setCode(code);
        type.setName(name);
        type.setSubType(subType);

        List<TypeBrand> typeBrands = new ArrayList<>();
        type.setBrands(typeBrands);
        if(brandIds != null && !brandIds.isEmpty()) {
            final val brands = brandRepository.findAllByIdIn(brandIds);
            for (Brand brand : brands) {
                TypeBrand typeBrand = new TypeBrand(type, brand);
                typeBrands.add(typeBrand);
            }
        }

        List<CategoryType> categoryTypes = new ArrayList<>();
        type.setCategories(categoryTypes);
        if(categoryIds != null && !categoryIds.isEmpty()) {
            final val categories = categoryRepository.findAllByIdIn(categoryIds);
            for (Category category : categories) {
                CategoryType categoryType = new CategoryType(category, type);
                categoryTypes.add(categoryType);
            }
        }

        final val typeEntity = typeRepository.save(type);
        return typeEntity;
    }
}
