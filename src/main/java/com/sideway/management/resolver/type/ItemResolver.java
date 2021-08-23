package com.sideway.management.resolver.type;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.sideway.management.model.*;
import com.sideway.management.repository.BrandRepository;
import com.sideway.management.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class ItemResolver implements GraphQLResolver<Item> {

    public Brand getBrand(Item item) {
        return item.getBrand();
    }

    public Type getType(Item item) {
        return item.getType();
    }

    public Category getCategory(Item item) {
        return item.getCategory();
    }

    public Model getModel(Item item) {
        return item.getModel();
    }
}
