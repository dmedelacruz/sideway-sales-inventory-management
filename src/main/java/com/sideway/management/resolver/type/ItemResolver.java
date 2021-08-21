package com.sideway.management.resolver.type;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.sideway.management.model.Brand;
import com.sideway.management.model.Item;
import com.sideway.management.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class ItemResolver implements GraphQLResolver<Item> {

    private final BrandRepository brandRepository;

    public Brand getBrand(Item item) {
        final val brand = item.getBrand();
        if(brand == null) {
            return null;
        } else {
            return brandRepository.findById(brand.getId())
                    .orElseThrow(() -> new EntityNotFoundException("No brand found"));
        }
    }

}
