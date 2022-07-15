package com.hashkart.product.api.service;
import com.hashkart.product.api.entity.OrderEntity;
import com.hashkart.product.api.entity.ProductEntity;

import com.hashkart.product.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductEntity> getAllProducts(){
        List<ProductEntity> listProducts = new ArrayList<>();
        listProducts = productRepository.findAll();
        return listProducts;
    }
    public Boolean removeQuantity(int id,int quantity){
        Optional<ProductEntity> productOptional = productRepository.findById(id);
        if(productOptional.isPresent()){
            ProductEntity product = productOptional.get();
            System.out.println(product.getQuantity());
            product.setQuantity(product.getQuantity()-quantity);
            productRepository.save(product);
            return true;
        }
        return false;
    }
    public Boolean addQuantity(int id,int quantity){
        Optional<ProductEntity> productOptional = productRepository.findById(id);
        if(productOptional.isPresent()){
            ProductEntity product = productOptional.get();
            System.out.println(product.getQuantity());
            product.setQuantity(product.getQuantity()+quantity);
            productRepository.save(product);
            return true;
        }
        return false;
    }
}
