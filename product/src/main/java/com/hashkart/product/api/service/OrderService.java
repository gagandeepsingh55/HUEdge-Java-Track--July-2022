package com.hashkart.product.api.service;
import com.hashkart.product.api.entity.OrderEntity;

import com.hashkart.product.api.entity.Payment;
import com.hashkart.product.api.entity.TransactionRequest;
import com.hashkart.product.api.entity.TransactionResponse;
import com.hashkart.product.api.repository.OrderRepository;
import com.hashkart.product.api.repository.ProductRepository;
import org.aspectj.bridge.IMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private RestTemplate restTemplate;

    public TransactionResponse productOrder(TransactionRequest transactionRequest){
        OrderEntity order = transactionRequest.getOrder();
        Payment payment = transactionRequest.getPayment();
        payment.setOrderId(order.getId());
        //Change the price after applying discount
        payment.setAmount(order.getPrice());
        //Rest Call to payment API
        Boolean productQuantityUpdated = productService.removeQuantity(order.getProductid(),order.getQuantity());
        System.out.println(productQuantityUpdated);
        Payment paymentResponse = restTemplate.postForObject("http://PAYMENT-SERVICE/payment/doPayment",payment,Payment.class);
        String message = paymentResponse.getPaymentStatus().equals("Success")?"Payment Successful":"Payment Failed";
        if(message.equals("Payment Failed")){
            order.setStatus("Payment Failed");
            Boolean productQuantity = productService.addQuantity(order.getProductid(),order.getQuantity());
            System.out.println(productQuantity);
        }else{
            order.setStatus("Payment Success");
        }

        orderRepository.save(order);

        return new TransactionResponse(order,paymentResponse.getAmount(),paymentResponse.getBankTransactionID(),message);
    }
    public Boolean updateOrderStatus(Integer id) {
        Optional<OrderEntity> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) {
            OrderEntity orderEntity = orderOptional.get();
            orderEntity.setStatus("Success");
            orderRepository.save(orderEntity);
            return true;
        }
        return false;
    }

}

