package com.hashkart.product.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "orderentity")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "userid")
    private int userid;
    @Column(name = "productid")
    private int productid;
    @Column(name = "status")
    private String status;
    @Column(name = "ordermethod")
    private String orderMethod;
    @Column(name = "price")
    private double price;
    @Column(name = "quantity")
    private int quantity;
}

//=========
//        CREATE TABLE orderentity(
//        id INT PRIMARY KEY,
//        status CHAR(50),
//        userid INT NOT NULL,
//        ordermethod CHAR(50) NOT NULL,
//        price REAL NOT NULL,
//        quantity INT NOT NULL,
//        productid int NOT NULL
//        );
//=========