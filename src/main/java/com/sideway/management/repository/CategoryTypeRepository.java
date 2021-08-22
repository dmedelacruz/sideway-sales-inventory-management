package com.sideway.management.repository;

import com.sideway.management.model.junctions.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryTypeRepository extends JpaRepository<CategoryType, Long> {

    List<CategoryType> findAllByCategory_Id(String categoryId);
    List<CategoryType> findAllByType_Id(String typeId);
}
