package com.controller;

import org.springframework.web.bind.annotation.RestController;

import com.entity.ProductEntity;
import com.repository.ProductRepository;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



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
	//api
	// read all products information 
	@GetMapping("/products")
	public List<ProductEntity> getAllProducts(ProductEntity productEntity){	
	  List<ProductEntity>	products = productRepository.findAll();
		return products;
	}
	
	// read product by Id
	//@GetMapping("/products/:productId") -- use in JavaScript 
	@GetMapping("/products/{productId}")
	public ProductEntity getProductById(@PathVariable("productId") Integer productId) {
		Optional<ProductEntity> product = productRepository.findById(productId);
		if(product.isEmpty()) {
			return null;
		}else {
			ProductEntity productEntity = product.get();
			return productEntity;
		}
	}
	
	//using @RequestParam
	@GetMapping("/productsById")
	public ProductEntity getProductById2(@RequestParam("productId") Integer productId) {
		Optional<ProductEntity> product = productRepository.findById(productId);
		if(product.isEmpty()) {
			return null;
		}else {
			ProductEntity productEntity = product.get();
			return productEntity;
		}
	}
	
	
	//Api -> remove product from the products table -> delete product
	//input -> productId
	@DeleteMapping("products/{productId}")
	public String deleteProductById(@PathVariable("productId") Integer productId) {
		Optional<ProductEntity> product = productRepository.findById(productId);
		if(product.isEmpty()) {
			return "Not Found";
		}else {
			productRepository.deleteById(productId);
			return "Delete Success";
		}
	}
	
	//update
	// input all product info that we can modify , product id must be present 
	
	@PutMapping("/products")
	public String updateProduct(@RequestBody ProductEntity productEntity) {
		
		productRepository.save(productEntity); // id is present 
		return "updated";
	}
}

//url :- http://localhost:8899/products	
