package com.sideway.management.repository;

import com.sideway.management.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Model, String> {

    @Query(value = "SELECT * FROM Model OFFSET ?1*?2 LIMIT ?2", nativeQuery = true)
    List<Model> findAllModels(Integer page, Integer pageSize);
    Model findByCode(String code);
    Model findByName(String name);

}
