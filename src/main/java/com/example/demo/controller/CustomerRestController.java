package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.entity.Customer;
import com.example.demo.service.ICustomerService;

@RestController
@RequestMapping(value = "/api")
public class CustomerRestController {
	
	private static final Logger log=  LoggerFactory.getLogger(CustomerRestController.class);
	
	@Autowired
	private ICustomerService customerService;
	
	@GetMapping(value= {"/", ""})
	public void init() {
		log.info("----- CustomerRestControllerv ::  init-----");
	}
	
	@GetMapping(value = "/customer", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Customer>> customerAll(){
		
		log.info("----- CustomerRestController :: customerAll -----");
		
		try {
			List<Customer> listCustomer = customerService.findAll();
			if(listCustomer == null || listCustomer.isEmpty()) {
				return new ResponseEntity<>(listCustomer, HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<>(listCustomer, HttpStatus.OK);
		}catch (Exception e) {
			log.error("Error en obtener todos los clientes: {}", e.getMessage());
			return new ResponseEntity<>((List<Customer>)null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/customer/{id}" , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Customer> customerFindById(@PathVariable("id") Long id){
		
		log.info("----- CustomerRestController :: customerFindById -----");
		
		try {
			Customer customer = customerService.findById(id);
			if(customer == null) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(customer, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Error en obtener el cliente {}: {}", id, e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value = "/customer", 
				produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
				consumes =  MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Customer> cutomerCreate(@RequestBody Customer customer){
		
		log.info("----- CustomerRestController :: cutomerCreate -----");
		
		try {
			Customer c = customerService.create(customer);
			if(c == null) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(c, HttpStatus.OK);
		}catch (Exception e) {
			log.error("Error al crear el cliente: {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(value = "/customer", 
				produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
				consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Customer> cutomerUpdate(@RequestBody Customer customer){
		
		log.info("----- CustomerRestController :: cutomerUpdate -----");
		
		try {
			Customer c = customerService.update(customer);
			if(c == null) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(c, HttpStatus.OK);
		}catch (Exception e) {
			log.error("Error al actualizar el cliente: {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value = "/customer/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Customer> cutomerDelete(@PathVariable("id") Long id){
		
		log.info("----- CustomerRestController :: cutomerDelete -----");
		
		try {
			Customer c = customerService.findById(id);
			if(c == null) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
			customerService.deleteById(id);
			return new ResponseEntity<>(c, HttpStatus.OK);
		}catch (Exception e) {
			log.error("Error al eliminar el cliente {}: {}", id,e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
