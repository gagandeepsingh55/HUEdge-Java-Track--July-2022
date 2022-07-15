package com.hashkart.product.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {
    private OrderEntity order;
    private double amount;
    private String transactionId;
    private String message;
}
