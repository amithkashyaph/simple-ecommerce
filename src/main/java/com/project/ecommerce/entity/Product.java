package com.project.ecommerce.entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    private Long productId;

    private String productName;
    private String description;
    private Integer quantity;
    private double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
