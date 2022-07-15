package com.hashkart.payment.controller;

import com.hashkart.payment.entity.Payment;
import com.hashkart.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableEurekaClient
@RequestMapping("/payment")
public class paymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/doPayment")
    public Payment doCardPayment(@RequestBody Payment payment){
        return paymentService.makePayment(payment);
    }
    @GetMapping("/getpaymentstatus")
    public String getPaymentStatus(@RequestParam("id") int orderid){
        return paymentService.getPaymentStatus(orderid);
    }
}
