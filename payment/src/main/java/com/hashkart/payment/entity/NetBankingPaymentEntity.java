package com.hashkart.payment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NetBankingPaymentEntity extends Payment {
    @Column(name = "bank")
    private int bank;

}
