package com.hashkart.payment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payment")
@Inheritance
@Entity

public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;
    @Column(name = "paymentstatus")
    private String paymentStatus;
    @Column(name = "transactionid")
    private String transactionID;
    @Column(name = "orderid")
    private int orderId;
    @Column(name = "amount")
    private double amount;
    @Column(name = "ordermethod")
    private String orderMethod;
}

//=========
//        CREATE TABLE payment(
//        id INT PRIMARY KEY,
//        paymentstatus CHAR(50) NOT NULL,
//        transactionid CHAR(50) NOT NULL,
//        orderid INT NOT NULL,
//        amount REAL NOT NULL,
//        bank CHAR(50),
//        cardnumber  CHAR(50),
//        expirymonth Date,
//        ordermethod CHAR(50),
//        dtype CHAR(50)
//        );
//CREATE SEQUENCE hibernate_sequence START 1;
//=========

