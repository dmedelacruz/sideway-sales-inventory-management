package com.sideway.management.resolver.mutation;

import com.sideway.management.model.Brand;
import com.sideway.management.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandMutationResolver extends MutationResolver{

    private final BrandRepository brandRepository;

    public Brand newBrand(String name, String code) {
        Brand brand = new Brand();
        brand.setName(name);
        brand.setCode(code);

        final val brandEntity = brandRepository.save(brand);
        return brandEntity;
    }

}
