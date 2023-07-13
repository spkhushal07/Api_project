package com.springrest.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.spring.details.productDetails;
import com.springrest.spring.entity.Product;
/*
 * @RestController is use to inform that this is my Controller class.
 * Rest= Representational State Transfer
 */
@RestController
public class MyController 
{
	/*
	 * @Autowired it will create a object for our interface implementation class and inject it prd_details Variable 
	 */
	@Autowired
	private productDetails prd_details;
	@GetMapping("/home")
	public String home()
	{
		return "Welcome to product Management Portal!!!!!!!";
	}
	@GetMapping("/product")
	public List<Product> getproductDetails()
	{
		return this.prd_details.getProductDetails();
	}
	@GetMapping("/product/{productId}")
	public Product getProduct(@PathVariable String productId)
	{
		return this.prd_details.getProduct(Integer.parseInt(productId));
	}
	@PostMapping("/newproduct")
	public Product newproduct(@RequestBody Product prd) 
	{
		return this.prd_details.newProduct(prd);
	}
	@PutMapping("/product")
	public Product updateProduct(@RequestBody Product product)
	{
		return this.prd_details.upadteProduct(product);
	}
	@DeleteMapping("/product/{productId}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable String productId)
	{
		try {
			this.prd_details.deleteProduct(Integer.parseInt(productId));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
}
}
