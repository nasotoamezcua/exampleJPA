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

import com.example.demo.dto.cloud.PersonaDomicilioDTO;
import com.example.demo.service.impl.cloud.PersonaDomicilioService;

import feign.FeignException;

@RestController
@RequestMapping("/cloud")
public class PersonaDomicilioRestController {
	
	private static final Logger log=  LoggerFactory.getLogger(PersonaDomicilioRestController.class);
	
	@Autowired
	PersonaDomicilioService personaDomicilioService;
	
	@GetMapping(value = "/domicilios/curp/{curp}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	ResponseEntity<List<PersonaDomicilioDTO>> findByDomiciliosRestController(@PathVariable("curp") String curp){
		
		log.info("----- findByDomiciliosRestController :: findByDomiciliosRestController -----");
		
		List<PersonaDomicilioDTO> listPersonaDomicilioDTO = null;
		
		try {
				listPersonaDomicilioDTO = personaDomicilioService.findByDomiciliosService(curp);
				return new ResponseEntity<List<PersonaDomicilioDTO>>(listPersonaDomicilioDTO, HttpStatus.OK);
			
		}catch (FeignException e) {
			switch (e.status()) {
			case 404:
				return new ResponseEntity<List<PersonaDomicilioDTO>>(listPersonaDomicilioDTO, HttpStatus.NOT_FOUND);

			default:
				return new ResponseEntity<List<PersonaDomicilioDTO>>(listPersonaDomicilioDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
	}

}
