package com.sideway.management.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Table(name = "model")
@Entity
@Data
public class Model extends BaseEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

}
