package com.sideway.management.repository;

import com.sideway.management.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeRepository extends JpaRepository<Type, String> {

    @Query(value = "SELECT * FROM Type OFFSET ?1*?2 LIMIT ?2", nativeQuery = true)
    List<Type> findAllTypes(Integer page, Integer pageSize);

    List<Type> findAllByIdIn(List<String> ids);

    Type findTypeByCode(String code);
    List<Type> findAllByName(String name);
}
