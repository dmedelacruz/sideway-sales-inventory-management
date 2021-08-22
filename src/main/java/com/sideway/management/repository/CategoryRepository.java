package com.sideway.management.repository;

import com.sideway.management.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

    @Query(value = "SELECT * FROM Category OFFSET ?1*?2 LIMIT ?2", nativeQuery = true)
    List<Category> findAllCategories(Integer page, Integer pageSize);
    List<Category> findAllByIdIn(List<String> ids);

    Category findByCode(String code);
    List<Category> findAllByName(String name);

}
