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

import com.example.demo.repository.entity.Order;
import com.example.demo.service.IOrderService;

@RestController
@RequestMapping(value = "/api")
public class OrderRestController {
	
	private static final Logger log=  LoggerFactory.getLogger(OrderRestController.class);
	
	@Autowired
	private  IOrderService orderService;
	
	@GetMapping(value = "/order", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Order>> orderAll(){
		
		log.info("----- OrderRestController :: orderAll -----");
		
		try {
			List<Order> listOrder = orderService.findAll();
			if(listOrder == null || listOrder.isEmpty()) {
				return new ResponseEntity<>(listOrder, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(listOrder, HttpStatus.OK);
		}catch (Exception e) {
			log.error("Error en obtener todas los Ordenes: {}", e.getMessage());
			return new ResponseEntity<>((List<Order>)null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/order/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Order> orderFindById(@PathVariable("id") Long id){
		
		log.info("----- OrderRestController :: orderFindById -----");
		
		try {
			Order order = orderService.findById(id);
			if(order == null) {
				return new ResponseEntity<>(order, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(order, HttpStatus.OK);
		}catch (Exception e) {
			log.error("Error en obtener La Orden {}: {}", id, e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
