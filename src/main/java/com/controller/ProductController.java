package com.controller;

import org.springframework.web.bind.annotation.RestController;

import com.entity.ProductEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ProductController {

	//api 
	// read product information and store into db
	
	@PostMapping("/products")
	public String addProduct(@RequestBody ProductEntity productEntity) {
		
		System.out.println(productEntity.getProductName());
		System.out.println(productEntity.getCategory());
		return "success";
	}
	
}

//url :- http://localhost:8899/products
