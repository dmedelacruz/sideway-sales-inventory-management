package com.sideway.management.resolver.query;

import com.sideway.management.model.Type;
import com.sideway.management.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeQueryResolver extends QueryResolver {

    private final TypeRepository typeRepository;

    public List<Type> findAllTypes(int page, int pageSize) {
        if(page < 1) {
            page = 1;
        }
        return typeRepository.findAllTypes(page - 1, pageSize);
    }

    public Type findTypeById(String id) {
        return typeRepository.findById(id).orElse(null);
    }

    public List<Type> findTypesByName(String name) {
        return typeRepository.findAllByName(name);
    }

    public Type findTypeByCode(String code) {
        return typeRepository.findTypeByCode(code);
    }

}
