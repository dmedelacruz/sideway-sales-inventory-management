package com.sideway.management.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Table(name = "model")
@Entity
@Data
public class Model {

    @Id
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name = "hibernate-uuid", strategy = "uuid2")
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "code", nullable = false)
    private String code;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "MODEL_BRAND",
            joinColumns = @JoinColumn(name = "MODEL_id"),
            inverseJoinColumns = @JoinColumn(name = "BRAND_id"))
    private List<Brand> brands;

}
