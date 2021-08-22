package com.sideway.management.repository;

import com.sideway.management.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, String> {

    @Query(value = "SELECT * FROM Brand OFFSET ?1*?2 LIMIT ?2", nativeQuery = true)
    List<Brand> findAllBrands(Integer page, Integer pageSize);
    Brand findByCode(String code);
    List<Brand> findAllByName(String name);
    List<Brand> findAllByIdIn(List<String> ids);
}
