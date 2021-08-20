package com.sideway.management.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Table(name = "brand")
@Entity
@Data
public class Brand {

    @Id
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name = "hibernate-uuid", strategy = "uuid2")
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "code", nullable = false)
    private String code;

    @ManyToMany
    @JoinTable(name = "BRAND_CATEGORY",
            joinColumns = @JoinColumn(name = "BRAND_id"),
            inverseJoinColumns = @JoinColumn(name = "CATEGORY_id"))
    private List<Category> categories;

}