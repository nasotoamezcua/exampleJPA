package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.convert.impl.ProductTypeConvert;
import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.ProductTypeAllDTO;
import com.example.demo.repository.entity.Product;
import com.example.demo.service.IProductService;

@RestController
@RequestMapping(value = "/api")
public class PropductRestController {
	
	private static final Logger log=  LoggerFactory.getLogger(PropductRestController.class);
	
	@Autowired
	private IProductService productService;
	
	@Autowired
	private ProductTypeConvert productConver;
	
	@GetMapping(value="/product", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Product>> productAll(){
		
		log.info("----- PropductRestController :: productAll -----");
		
		try {
			List<Product> listProduct = productService.findAll();
			if(listProduct == null || listProduct.isEmpty()) {
				return new ResponseEntity<>(listProduct, HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<>(listProduct, HttpStatus.OK);
		}catch (Exception e) {
			log.error("Error en obtener todos los Productos: {}", e.getMessage());
			return new ResponseEntity<>((List<Product>)null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/product/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Product> productFindById(@PathVariable(name = "id") Long id){
		log.info("----- PropductRestController :: productFindById -----");
		
		try {
			Product product = productService.findById(id);
			if(product == null) {
				return new ResponseEntity<>(product, HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<>(product, HttpStatus.OK);
		}catch (Exception e) {
			log.error("Error en obtener el Producto {}: {}", id, e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping(value = "/productDTO" , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<ProductDTO>> productDTOAll(){
		
		log.info("----- PropductRestController :: productDTOAll -----");
		
		try {
			List<Product> listProduct = productService.findAll();
			List<ProductDTO> listProductDTO = null;
			
			if(listProduct == null || listProduct.isEmpty()) {
				return new ResponseEntity<>(listProductDTO,HttpStatus.NOT_FOUND);
			}
			
			listProductDTO = productConver.converProductDTO(listProduct);
			return new ResponseEntity<>(listProductDTO, HttpStatus.OK);
			
		}catch (Exception e) {
			log.error("Error en obtener todos los ProductosDTO: {}", e.getMessage());
			return new ResponseEntity<>((List<ProductDTO>)null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/productTypeAllDTO" , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<ProductTypeAllDTO>> productTypeAllDTOAll(){
		
		log.info("----- PropductRestController :: productTypeAllDTOAll -----");
		
		try {
			List<Product> listProduct = productService.findAll();
			List<ProductTypeAllDTO> listProductTypeAllDTO = null;
			
			if(listProduct == null || listProduct.isEmpty()) {
				return new ResponseEntity<>(listProductTypeAllDTO,HttpStatus.NOT_FOUND);
			}
			
			listProductTypeAllDTO = productConver.convertProductTypeAllDTO(listProduct);
			return new ResponseEntity<>(listProductTypeAllDTO, HttpStatus.OK);
			
		}catch (Exception e) {
			log.error("Error en obtener todos los ProductosDTO: {}", e.getMessage());
			return new ResponseEntity<>((List<ProductTypeAllDTO>)null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
