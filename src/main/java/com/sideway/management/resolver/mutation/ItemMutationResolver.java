package com.sideway.management.resolver.mutation;

import com.sideway.management.model.Item;
import com.sideway.management.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class ItemMutationResolver extends MutationResolver {

    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;
    private final TypeRepository typeRepository;
    private final BrandRepository brandRepository;
    private final ModelRepository modelRepository;

    public Item newItem(
            String code,
            String description,
            String details,
            Integer currentStock,
            Integer lowStockThreshold,
            Float capital,
            Float recommendedSellingPrice,
            String categoryId,
            String typeId,
            String brandId,
            String modelId
    ) {
        Item item = new Item();
        item.setCode(code);
        item.setDescription(description);
        item.setDetails(details);
        item.setCurrentStock(currentStock);
        item.setLowStockThreshold(lowStockThreshold);
        item.setCapital(capital);
        item.setRecommendedSellingPrice(recommendedSellingPrice);

        if(categoryId == null || categoryId.isBlank()) {
            item.setCategory(null);
        } else {
            final val category = categoryRepository.findById(categoryId)
                    .orElseThrow(() -> new EntityNotFoundException("No Category found for given ID"));
            item.setCategory(category);
        }

        if(typeId == null || typeId.isBlank()) {
            item.setType(null);
        } else {
            final val type = typeRepository.findById(typeId)
                    .orElseThrow(() -> new EntityNotFoundException("No Type found for given ID"));
            item.setType(type);
        }

        if(brandId == null || brandId.isBlank()) {
            item.setBrand(null);
        } else {
            final val brand = brandRepository.findById(brandId)
                    .orElseThrow(() -> new EntityNotFoundException("No Brand found for given ID"));
            item.setBrand(brand);
        }

        if(modelId != null && !modelId.isBlank()) {
            final val model = modelRepository.findById(modelId).orElse(null);
            item.setModel(model);
        } else {
            item.setModel(null);
        }


        final val itemEntity = itemRepository.save(item);
        return itemEntity;

    }

    public Item updateItemStock(String id, Integer currentStock) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No Item Record found for the given ID"));

        item.setCurrentStock(currentStock);
        final val itemEntity = itemRepository.save(item);
        return itemEntity;
    }

}
