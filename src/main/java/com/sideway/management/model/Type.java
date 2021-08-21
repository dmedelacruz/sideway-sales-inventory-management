package com.sideway.management.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Table(name = "type")
@Entity
@Data
public class Type {

    @Id
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name = "hibernate-uuid", strategy = "uuid2")
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "subtype")
    private String subtype;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "TYPE_MODEL",
            joinColumns = @JoinColumn(name = "TYPE_id"),
            inverseJoinColumns = @JoinColumn(name = "MODEL_id"))
    private List<Model> models;

}
