package com.hashkart.payment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCartPaymentEntity extends Payment {
    @Column(name = "cardnumber")
    private int CardNumber;
    @Column(name = "expirymonth")
    private Date expiryMonth;

}
