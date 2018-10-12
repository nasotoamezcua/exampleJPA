package com.example.demo.convert.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.ProductTypeAllDTO;
import com.example.demo.dto.ProductTypeDTO;
import com.example.demo.repository.entity.Product;
import com.example.demo.repository.entity.ProductType;

@Component
public class ProductTypeConvert {
	
	public List<ProductDTO> converProductDTO(List<Product> product){
		
		List<ProductDTO> listProductDTO = null;
		ProductDTO pDto = null;
		ProductTypeDTO ptDto = null;
		
		try {
			if(product != null) {
				listProductDTO = new ArrayList<ProductDTO>();
				
				for(Product p: product) {
					ptDto = new ProductTypeDTO(p.getProductType().getId(), 
									new Date(), 
									p.getProductType().getName());
					
					pDto = new ProductDTO(p.getId(), new Date(), p.getName(), p.getDescription(), ptDto);
					
					listProductDTO.add(pDto);
				}
			}
			
		}catch (Exception e) {
			e.getMessage();
		}
		
		return listProductDTO;
		
	}
	
	public List<ProductTypeDTO> convertProductTypeDTO(List<ProductType> productType){
		
		List<ProductTypeDTO> listProductTypeDTO = null;
		ProductTypeDTO ptDto = null;
		List<ProductDTO> listProdcutDTO = null;
		
		if(productType != null) {
			listProductTypeDTO = new ArrayList<ProductTypeDTO>();
			//CICLO DE LA LISTA ProductType
			for(ProductType pt :productType) {
				
				if(pt.getProducts() != null) {
					listProdcutDTO = new ArrayList<ProductDTO>();
					
					//CICLO DE LA LISTA Product
					for(Product p: pt.getProducts()) {
						
						listProdcutDTO.add(new ProductDTO(p.getId(), 
												new Date(), 
												p.getName(), 
												p.getDescription()));
					}
				}
				
				ptDto = new ProductTypeDTO(pt.getId(), new Date(), pt.getName(), listProdcutDTO);
				listProductTypeDTO.add(ptDto);
			}
		}
		
		return listProductTypeDTO;
	}
	
	public List<ProductTypeAllDTO> convertProductTypeAllDTO(List<Product> product){
		
		List<ProductTypeAllDTO> listProductTypeAllDTO = null;
		ProductTypeAllDTO ptaDto = null;
		
		try {
			if(product != null) {
				listProductTypeAllDTO = new ArrayList<ProductTypeAllDTO>();
				
				for(Product p: product) {
					
					ptaDto = new ProductTypeAllDTO(new Date(), 
							p.getProductType().getId(), 
							p.getProductType().getName(), 
							p.getId(), 
							p.getName(), 
							p.getDescription());
					
					listProductTypeAllDTO.add(ptaDto);
				}
			}
			
		}catch (Exception e) {
			e.getMessage();
		}
		
		return listProductTypeAllDTO;
		
	}
}
