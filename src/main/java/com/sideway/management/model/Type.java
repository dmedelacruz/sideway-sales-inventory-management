package com.sideway.management.model;

import com.sideway.management.model.junctions.CategoryType;
import com.sideway.management.model.junctions.TypeBrand;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Table(name = "type")
@Entity
@Data
public class Type extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "subtype")
    private String subType;

    @OneToMany(mappedBy = "type", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<CategoryType> categories;

    @OneToMany(mappedBy = "type", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<TypeBrand> brands;

}
