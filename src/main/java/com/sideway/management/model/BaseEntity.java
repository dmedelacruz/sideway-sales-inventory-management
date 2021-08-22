package com.sideway.management.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public class BaseEntity {

    @Id
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name = "hibernate-uuid", strategy = "uuid2")
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

}
