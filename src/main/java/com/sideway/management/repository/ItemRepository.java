package com.sideway.management.repository;

import com.sideway.management.model.Brand;
import com.sideway.management.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {

    Item findByCode(String code);

}
