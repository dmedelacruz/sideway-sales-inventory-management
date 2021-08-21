package com.sideway.management.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Table(name = "category")
@Entity
@Data
public class Category {

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
    @JoinTable(name = "CATEGORY_TYPE",
            joinColumns = @JoinColumn(name = "CATEGORY_id"),
            inverseJoinColumns = @JoinColumn(name = "TYPE_id"))
    private List<Type> types;

}
