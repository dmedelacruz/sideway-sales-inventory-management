package com.sideway.management.model.junctions;

import com.sideway.management.model.Brand;
import com.sideway.management.model.Type;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "type_brand")
@Entity
@Data
@NoArgsConstructor
public class TypeBrand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "type_id", nullable = false)
    private Type type;

    @ManyToOne(optional = false)
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    public TypeBrand(Type type, Brand brand) {
        this.type = type;
        this.brand = brand;
    }
}
