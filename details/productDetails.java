package com.springrest.spring.details;

import java.util.List;

import com.springrest.spring.entity.Product;

public interface productDetails
{
	public List<Product> getProductDetails();
	
	public Product getProduct(int ProductId);
	
	public Product newProduct(Product prd);
	
	public Product upadteProduct(Product ProductId);
	
	public void deleteProduct(int ProductId);
}
