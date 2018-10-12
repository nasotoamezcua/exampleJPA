package com.example.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.repository.entity.Product;
import com.example.demo.repository.entity.ProductType;
import com.example.demo.service.IProductService;
import com.example.demo.service.IProductTypeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTest {
	
	@Autowired
	IProductService productService;
	
	@Autowired
	IProductTypeService productTypeService;
	
	@Test
	public void productAllTest() {
		try {
			List<Product> listProduct = productService.findAll();
			if(listProduct != null) {
				for(Product p : listProduct) {
					System.out.println(p);
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	@Test
	public void productTypeAllTest() {
		try {
			List<ProductType> listProductType = productTypeService.findAll();
			if(listProductType != null) {
				for(ProductType pt : listProductType) {
					System.out.println(pt);
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
