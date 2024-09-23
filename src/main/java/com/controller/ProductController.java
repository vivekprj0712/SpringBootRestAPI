package com.controller;

import org.springframework.web.bind.annotation.RestController;

import com.entity.ProductEntity;
import com.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ProductController {

	@Autowired
	ProductRepository productRepository;

	
	
	//api 
	// read product information and store into db
	
	@PostMapping("/products")
	public ProductEntity addProduct(@RequestBody ProductEntity productEntity) {
		
		System.out.println(productEntity.getProductName());
		System.out.println(productEntity.getCategory());
		productRepository.save(productEntity);
		return productEntity;
	}
	
}

//url :- http://localhost:8899/products	
