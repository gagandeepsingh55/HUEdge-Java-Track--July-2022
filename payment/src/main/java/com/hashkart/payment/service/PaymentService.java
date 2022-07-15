package com.hashkart.payment.service;

import com.hashkart.payment.entity.Payment;
import com.hashkart.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public Payment makePayment(Payment payment){
        payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionID(UUID.randomUUID().toString());
        // Ask how to enter values in CreditCardEntity Class or NetBankingEntity Class
        return paymentRepository.save(payment);
    }
    public String paymentProcessing(){
        return new Random().nextBoolean()?"Success":"Failed";
    }

    public String getPaymentStatus(int orderid) {
        Payment payment = paymentRepository.findStatusbyOrderId(orderid);
        System.out.println(payment.getPaymentStatus());
        return payment.getPaymentStatus();
    }
}
