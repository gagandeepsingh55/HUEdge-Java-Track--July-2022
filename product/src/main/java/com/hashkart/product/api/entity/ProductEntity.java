package com.hashkart.product.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "description")
    private String description;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "category")
    private String category;
    @Column(name = "price")
    private double price;
}

//=========
//        CREATE TABLE product(
//        id INT PRIMARY KEY,
//        quantity INT,
//        category CHAR(50) NOT NULL,
//        description CHAR(50) NOT NULL,
//        price REAL NOT NULL
//        );
//=======