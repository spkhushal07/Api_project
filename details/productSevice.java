package com.springrest.spring.details;

import java.util.ArrayList;

import java.util.List;
//import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springrest.spring.entity.Product;
@Service
public class productSevice implements productDetails 
{
	List<Product>List;
	
	public productSevice() 
	{
		List =new ArrayList<>();
		List.add(new Product(101, "Realme X7", "Mobile Phones", 19890.00));
		List.add(new Product(102, "Samsung Z Flip 3", "Mobile Phones", 47500.00));
	}

	@Override
	public List<Product> getProductDetails() {
		
		return List;
	}

	@Override
	public Product getProduct(int ProductId) {
		Product id=null;
		for(Product prd:List)
		{
			if(prd.getProductId()==ProductId)
			{
				id=prd;
				break;
			}
		}
		return id;
	}

	@Override
	public Product newProduct(Product prd) {
		List.add(prd);
		return prd;
	}

	@Override
	public Product upadteProduct(Product ProductId) {
		List.forEach(e ->{
			if(e.getProductId()==ProductId.getProductId()) {
				e.setProductName(ProductId.getProductName());
				e.setProductCategory(ProductId.getProductCategory());
				e.setPrice(ProductId.getPrice());
			}
		});
		return ProductId;
	}

	@Override
	public void deleteProduct(int ProductId) {
		List=this.List.stream().filter(e->e.getProductId()!=ProductId).collect(Collectors.toList());
		
	}

}
