package com.hashkart.product.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance
public class Payment {
    private int id;
    private String paymentStatus;
    private String bankTransactionID;
    private int orderId;
    private double amount;
    private String orderMethod;
}
