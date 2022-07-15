package com.hashkart.product.api.controller;

import com.hashkart.product.api.entity.*;
import com.hashkart.product.api.service.OrderService;
import com.hashkart.product.api.service.ProductService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/list")
    public List<ProductEntity> getAllProducts(@RequestParam(value="sort", required = false) String category ){
        return productService.getAllProducts();
    }

    @PostMapping("/createorder")
    public TransactionResponse orderBooking(@RequestBody TransactionRequest transactionRequest){
        return orderService.productOrder(transactionRequest);
    }

    @PostMapping("/updateStatus")
    public Boolean updateOrderStatus(@RequestParam(value = "id", required = true) Integer id ){
        return orderService.updateOrderStatus(id);
    }
}

