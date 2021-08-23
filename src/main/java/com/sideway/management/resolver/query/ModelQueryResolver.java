package com.sideway.management.resolver.query;

import com.sideway.management.model.Model;
import com.sideway.management.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModelQueryResolver extends QueryResolver {

    private final ModelRepository modelRepository;

    public List<Model> findAllModels(int page, int pageSize) {
        if(page < 1) {
            page = 1;
        }
        return modelRepository.findAllModels(page - 1, pageSize);
    }

    public Model findModelById(String id) {
        return modelRepository.findById(id).orElse(null);
    }

    public Model findModelByCode(String code) {
        return modelRepository.findByCode(code);
    }

    public Model findModelByName(String name) {
        return modelRepository.findByName(name);
    }
}
