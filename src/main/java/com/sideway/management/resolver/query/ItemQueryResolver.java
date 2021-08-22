package com.sideway.management.resolver.query;

import com.sideway.management.model.Item;
import com.sideway.management.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemQueryResolver extends QueryResolver {

    private final ItemRepository itemRepository;

    public List<Item> findAllItems() {
        return itemRepository.findAll();
    }

    public Item findItemById(String id) {
        return itemRepository.findById(id).orElse(null);
    }

    public Item findItemByCode(String code) {
        return itemRepository.findByCode(code);
    }
}
