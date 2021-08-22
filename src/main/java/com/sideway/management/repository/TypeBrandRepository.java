package com.sideway.management.repository;

import com.sideway.management.model.junctions.TypeBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeBrandRepository extends JpaRepository<TypeBrand, Long> {

    List<TypeBrand> findAllByBrand_Id(String brandId);
    List<TypeBrand> findAllByType_Id(String typeId);

}
