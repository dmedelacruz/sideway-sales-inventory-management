package com.sideway.management.resolver.type;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.sideway.management.model.Brand;
import com.sideway.management.model.Type;
import com.sideway.management.repository.TypeBrandRepository;
import com.sideway.management.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BrandResolver implements GraphQLResolver<Brand> {

    private final TypeRepository typeRepository;
    private final TypeBrandRepository typeBrandRepository;

    public List<Type> getTypes(Brand brand) {
        final val typeBrands = typeBrandRepository.findAllByBrand_Id(brand.getId());
        if(typeBrands != null && !typeBrands.isEmpty()) {
            final val typeIds = typeBrands.stream().map(t -> t.getType().getId()).collect(Collectors.toList());
            return typeRepository.findAllByIdIn(typeIds);
        } else {
            return Collections.emptyList();
        }
    }
}
