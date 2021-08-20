package com.sideway.management.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Table(name = "item")
@Entity
public class Item {

    @Id
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name = "hibernate-uuid", strategy = "uuid2")
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "description")
    private String description;

    @Column(name = "details")
    private String details;

    @Column(name = "current_stock", nullable = false)
    private Integer currentStock;

    @Column(name = "low_stock_threshold")
    private Integer lowStockThreshold;

    @Transient
    private Boolean lowInStock;

    @Column(name = "capital", nullable = false)
    private Double capital;

    @Column(name = "recommended_selling_price", nullable = false)
    private Double recommendedSellingPrice;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

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