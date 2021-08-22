package com.sideway.management.model;

import com.sideway.management.model.junctions.TypeBrand;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Table(name = "brand")
@Entity
@Data
public class Brand extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "brand", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<TypeBrand> types;

}
