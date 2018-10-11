package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.convert.impl.OrderItemsConvert;
import com.example.demo.dto.OrderItemsFullDTO;
import com.example.demo.dto.OrderOrganizadoDTO;
import com.example.demo.repository.entity.OrderItems;
import com.example.demo.service.IOrderItemsService;

@RestController
@RequestMapping("/api")
public class OrderItemsRestController {
	
	private static final Logger log=  LoggerFactory.getLogger(OrderItemsRestController.class);
	
	@Autowired
	private IOrderItemsService orderIntemsService;
	
	@Autowired
	private OrderItemsConvert orderItemsConvert;
	
	@GetMapping("/orderItems")
	public ResponseEntity<List<OrderItems>> orderItemsAll(){
		
		log.info("----- OrderItemsRestController :: orderItemsAll -----");
		
		try {
			List<OrderItems> listOrderItems = orderIntemsService.findAll();
			if(listOrderItems == null || listOrderItems.isEmpty()) {
				return new ResponseEntity<>(listOrderItems, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(listOrderItems, HttpStatus.OK);
		}catch (Exception e) {
			log.error("Error en obtener todas las OrdenItems: {}", e.getMessage());
			return new ResponseEntity<>((List<OrderItems>)null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/orderItems/{id}")
	public ResponseEntity<OrderItems> orderItemsFindById(@PathVariable("id") Long id){
		log.info("----- OrderItemsRestController :: orderItemsFindById -----");
		
		try {
			OrderItems orderItem = orderIntemsService.findById(id);
			if(orderItem == null) {
				return new ResponseEntity<>(orderItem, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(orderItem, HttpStatus.OK);
		}catch (Exception e) {
			log.error("Error en obtener La OrdenItems {}: {}", id, e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/orderItems/OrderId/{id}")
	public ResponseEntity<List<OrderItems>> orderItemsFindByOrderId(@PathVariable("id") Long id){
		
		log.info("----- OrderItemsRestController :: orderItemsAll -----");
		
		try {
			List<OrderItems> listOrderItemsOrderId = orderIntemsService.findByOrderId(id);
			
			if(listOrderItemsOrderId == null || listOrderItemsOrderId.isEmpty()) {
				return new ResponseEntity<>(listOrderItemsOrderId, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(listOrderItemsOrderId, HttpStatus.OK);
		}catch (Exception e) {
			log.error("Error en obtener todas las OrdenItems: {}", e.getMessage());
			return new ResponseEntity<>((List<OrderItems>)null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/orderItems/OrderIdDto/{id}/{idOrg}")
	public ResponseEntity<?> orderItemsDtoFindByOrderId(@PathVariable("id") Long id, 
													@PathVariable("idOrg") Integer idOrg){
		
		log.info("----- OrderItemsRestController :: orderItemsDtoFindByOrderId -----");
		
		try {
			List<OrderItems> listOrderItemsDtoOrderId = orderIntemsService.findByOrderId(id);
			
			if(idOrg == 1) {
				OrderItemsFullDTO orderItemFullDto = orderItemsConvert.converOrderItemsFull(listOrderItemsDtoOrderId);
				
				if(orderItemFullDto == null) {
					return new ResponseEntity<>(orderItemFullDto, HttpStatus.NOT_FOUND);
				}
				return new ResponseEntity<>(orderItemFullDto, HttpStatus.OK);
			}else {
				OrderOrganizadoDTO orderOrganizadoDto = orderItemsConvert.converOrderItemsOrganizado(listOrderItemsDtoOrderId);
				
				if(orderOrganizadoDto == null) {
					return new ResponseEntity<>(orderOrganizadoDto, HttpStatus.NOT_FOUND);
				}
				return new ResponseEntity<>(orderOrganizadoDto, HttpStatus.OK);
			}
			
		}catch (Exception e) {
			log.error("Error en obtener todas las OrdenItems: {}", e.getMessage());
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	

}
