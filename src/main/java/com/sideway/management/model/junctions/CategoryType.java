package com.sideway.management.model.junctions;

import com.sideway.management.model.Category;
import com.sideway.management.model.Type;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "category_type")
@Entity
@Data
@NoArgsConstructor
public class CategoryType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne(optional = false)
    @JoinColumn(name = "type_id", nullable = false)
    private Type type;

    public CategoryType(Category category, Type type) {
        this.category = category;
        this.type = type;
    }
}
