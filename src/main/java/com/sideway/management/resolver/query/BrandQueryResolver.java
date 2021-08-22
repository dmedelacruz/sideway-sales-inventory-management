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

    public List<Brand> findAllBrands(int page, int pageSize) {
        if(page < 1) {
            page = 1;
        }
        return brandRepository.findAllBrands(page - 1, pageSize);
    }

    public Brand findBrandById(String id) {
        return brandRepository.findById(id).orElse(null);
    }

    public Brand findBrandByCode(String code) {
        return brandRepository.findByCode(code);
    }

    public List<Brand> findBrandsByName(String name) {
        return brandRepository.findAllByName(name);
    }
}
