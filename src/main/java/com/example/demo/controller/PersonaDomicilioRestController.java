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

import com.example.demo.dto.PersonaSeisDPDTO;
import com.example.demo.dto.cloud.PersonaDomicilioDTO;
import com.example.demo.service.cloud.IPersonaDomicilioService;

import feign.FeignException;

@RestController
@RequestMapping("/cloud")
public class PersonaDomicilioRestController {
	
	private static final Logger log=  LoggerFactory.getLogger(PersonaDomicilioRestController.class);
	
	@Autowired
	IPersonaDomicilioService personaDomicilioService;
	
	@GetMapping(value = "/domicilios/curp/{curp}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	ResponseEntity<List<PersonaDomicilioDTO>> findByDomiciliosCurpRestController(@PathVariable("curp") String curp){
		
		log.info("----- findByDomiciliosCurpRestController :: findByDomiciliosCurpRestController -----");
		
		List<PersonaDomicilioDTO> listPersonaDomicilioDTO = null;
		
		try {
				listPersonaDomicilioDTO = personaDomicilioService.findByDomiciliosCurpService(curp);
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
	
	@GetMapping(value = "/domicilios/cadena/{cadena}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	ResponseEntity<List<PersonaDomicilioDTO>> findByDomiciliosCadenaRestController(@PathVariable("cadena") String cadena){
		
		log.info("----- findByDomiciliosCadenaRestController :: findByDomiciliosCadenaRestController -----");
		
		List<PersonaDomicilioDTO> listPersonaDomicilioDTO = null;
		
		try {
				listPersonaDomicilioDTO = personaDomicilioService.findByDomiciliosCadenaService(cadena);
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
	
	@GetMapping(value = "/domicilios/datosPersonales/{nombre}/{primerApellido}/{segundoApellido}/{fechaNacimiento}/{sexo}/{entidad}" , produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<PersonaDomicilioDTO>> findByDomiciliosDatosPersonalesRestController(@PathVariable("nombre") String nombre, 
			@PathVariable("primerApellido") String primerApellido, 
			@PathVariable("segundoApellido") String segundoApellido, 
			@PathVariable("fechaNacimiento") String fechaNacimiento,
			@PathVariable("sexo") String sexo,  
			@PathVariable("entidad") Integer entidad){
		
		log.info("----- findByDomiciliosDatosPersonalesRestController :: findByDomiciliosDatosPersonalesRestController -----");
		
		List<PersonaDomicilioDTO> listPersonaDomicilioDTO = null;
		
		PersonaSeisDPDTO personaSeisDPDTO = new PersonaSeisDPDTO();
		personaSeisDPDTO.setNombre(nombre);
		personaSeisDPDTO.setPrimerApellido(primerApellido);
		personaSeisDPDTO.setSegundoApellido(segundoApellido);
		personaSeisDPDTO.setSexo(sexo);
		personaSeisDPDTO.setFechaNacimiento(fechaNacimiento);
		personaSeisDPDTO.setEntidad(entidad);
		
		try {
				listPersonaDomicilioDTO = personaDomicilioService.findByDomiciliosDatosPersonalesService(personaSeisDPDTO);
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
