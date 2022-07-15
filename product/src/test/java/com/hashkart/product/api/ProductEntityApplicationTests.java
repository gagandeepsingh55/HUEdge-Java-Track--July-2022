package com.hashkart.product.api;

import com.hashkart.product.api.entity.ProductEntity;
import com.hashkart.product.api.repository.ProductRepository;
import com.hashkart.product.api.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductEntityApplicationTests {
	@Autowired
	private ProductService service;
	@MockBean
	private ProductRepository productRepository;
	@Test
	public void getAllProductsTest(){
		when(productRepository.findAll()).thenReturn(Stream.of(
				new ProductEntity(101,"Eclipse",5,"Software",500),
				new ProductEntity(102,"Microsoft Teams",10,"Software",600),
				new ProductEntity(103,"Microsoft Office",11,"Software",1000)).
				collect(Collectors.toList()));
		assertEquals(3,service.getAllProducts().size());
	}

}
