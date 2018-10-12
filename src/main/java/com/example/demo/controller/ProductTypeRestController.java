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
import com.example.demo.dto.ProductTypeDTO;
import com.example.demo.repository.entity.ProductType;
import com.example.demo.service.IProductTypeService;

@RestController
@RequestMapping(value = "/api")
public class ProductTypeRestController {
	
	private static final Logger log=  LoggerFactory.getLogger(ProductTypeRestController.class);
	
	@Autowired
	private IProductTypeService producTypeService;
	
	@Autowired
	private ProductTypeConvert productTypeConver;
	
	@GetMapping(value = "/productType", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<ProductType>> productTypeAll(){
		
		log.info("----- ProductTypeRestController :: productTypeAll -----");
		
		try {
			List<ProductType> listProductType= producTypeService.findAll();
			
			if(listProductType == null || listProductType.isEmpty()) {
				return new ResponseEntity<>(listProductType, HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<>(listProductType, HttpStatus.OK);
		}catch (Exception e) {
			log.error("Error en obtener todos los Tipos de Productos: {}", e.getMessage());
			return new ResponseEntity<>((List<ProductType>)null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/productType/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ProductType> productTypeFindById(@PathVariable("id") Long id){
		
		log.info("----- ProductTypeRestController :: productTypeFindById -----");
		
		try {
			ProductType productType = producTypeService.findById(id);
			
			if(productType == null) {
				return new ResponseEntity<>(productType, HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<ProductType>(productType, HttpStatus.OK);
		}catch (Exception e) {
			log.error("Error en obtener el Tipo de Producto {}: {}", id, e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/productTypeDTO", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<ProductTypeDTO>> productTypeDTOAll(){
		
		log.info("----- ProductTypeRestController :: productTypeDTOAll -----");
		
		try {
			List<ProductType> listProductType= producTypeService.findAll();
			List<ProductTypeDTO> listProductTypeDTO = null;
			
			if(listProductType == null || listProductType.isEmpty()) {
				return new ResponseEntity<>(listProductTypeDTO, HttpStatus.NOT_FOUND);
			}
			
			listProductTypeDTO = productTypeConver.convertProductTypeDTO(listProductType);
			return new ResponseEntity<>(listProductTypeDTO, HttpStatus.OK);
			
		}catch (Exception e) {
			log.error("Error en obtener todos los Tipos de ProductosDTO: {}", e.getMessage());
			return new ResponseEntity<>((List<ProductTypeDTO>)null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
