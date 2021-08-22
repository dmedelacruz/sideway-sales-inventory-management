package com.sideway.management.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Table(name = "item")
@Entity
@Data
public class Item extends BaseEntity {

    @Column(name = "description")
    private String description;

    @Column(name = "details")
    private String details;

    @Column(name = "current_stock", nullable = false)
    private Integer currentStock;

    @Column(name = "low_stock_threshold", nullable = false)
    private Integer lowStockThreshold;

    @Transient
    private Boolean lowInStock;

    @Column(name = "capital", nullable = false)
    private Float capital;

    @Column(name = "recommended_selling_price", nullable = false)
    private Float recommendedSellingPrice;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @Transient
    public Boolean isLowInStock() {
        return this.currentStock < this.lowStockThreshold;
    }
}
