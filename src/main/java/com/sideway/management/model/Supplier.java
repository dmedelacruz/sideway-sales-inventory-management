package com.sideway.management.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Table(name = "supplier")
@Entity
@Data
public class Supplier extends BaseEntity {

//    @Id
//    @GeneratedValue(generator = "hibernate-uuid")
//    @GenericGenerator(name = "hibernate-uuid", strategy = "uuid2")
//    @Column(name = "id", nullable = false)
//    private String id;

    @Column(name = "name", nullable = false)
    private String name;

//    @Column(name = "code", nullable = false)
//    private String code;

}
