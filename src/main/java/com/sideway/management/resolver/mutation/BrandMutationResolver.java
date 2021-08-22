package com.sideway.management.resolver.mutation;

import com.sideway.management.exception.validation.DuplicateCodeException;
import com.sideway.management.model.Brand;
import com.sideway.management.model.Type;
import com.sideway.management.model.junctions.TypeBrand;
import com.sideway.management.repository.BrandRepository;
import com.sideway.management.repository.TypeBrandRepository;
import com.sideway.management.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandMutationResolver extends MutationResolver{

    private final BrandRepository brandRepository;
    private final TypeRepository typeRepository;

    public Brand newBrand(String code, String name, List<String> typeIds) {
        try{
            Brand brand = new Brand();
            brand.setCode(code);
            brand.setName(name);

            List<TypeBrand> typeBrands = new ArrayList<>();
            brand.setTypes(typeBrands);
            if(typeIds != null && !typeIds.isEmpty()) {
                final val types = typeRepository.findAllByIdIn(typeIds);
                for (Type type : types) {
                    TypeBrand typeBrand = new TypeBrand(type, brand);
                    typeBrands.add(typeBrand);
                }
            }

            final val brandEntity = brandRepository.save(brand);
            return brandEntity;
        } catch (DataIntegrityViolationException dataIntegrityViolationException) {
            throw new DuplicateCodeException("Brand code already exists");
        }
    }

}
