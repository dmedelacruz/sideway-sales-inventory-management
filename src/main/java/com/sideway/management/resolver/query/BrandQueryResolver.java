package com.sideway.management.resolver.query;

import com.sideway.management.model.Brand;
import com.sideway.management.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandQueryResolver extends QueryResolver{

    private final BrandRepository brandRepository;

    public List<Brand> findAllBrands() {
        return brandRepository.findAll();
    }

    public Brand findBrandById(String id) {
        return brandRepository.findById(id).orElse(null);
    }
}
