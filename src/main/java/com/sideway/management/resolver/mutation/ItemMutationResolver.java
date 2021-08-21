package com.sideway.management.resolver.mutation;

import com.sideway.management.model.Item;
import com.sideway.management.repository.BrandRepository;
import com.sideway.management.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class ItemMutationResolver extends MutationResolver {

    private final BrandRepository brandRepository;
    private final ItemRepository itemRepository;

    public Item newItem(
            String code,
            String description,
            String details,
            Integer currentStock,
            Integer lowStockThreshold,
            Float capital,
            Float recommendedSellingPrice,
            String brandId
    ) {
        Item item = new Item();
        item.setCode(code);
        item.setDescription(description);
        item.setDetails(details);
        item.setCurrentStock(currentStock);
        item.setLowStockThreshold(lowStockThreshold);
        item.setCapital(capital);
        item.setRecommendedSellingPrice(recommendedSellingPrice);

        if(brandId == null) {
            item.setBrand(null);
        } else {
            final val brand = brandRepository.findById(brandId)
                    .orElseThrow(() -> new EntityNotFoundException("No Brand found for given ID"));
            item.setBrand(brand);
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
