package com.example.demo.service.cloud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.service.cloud.impl.PersonaDomicilioCloudFallBack;

@FeignClient(name = "domicilios-api", fallback = PersonaDomicilioCloudFallBack.class)
public interface IPersonaDomicilioCloud {
	
	@RequestMapping(value = "/domicilio/curp/{curp}", method = RequestMethod.GET)
	String findByDomiciliosCurpCloud(@PathVariable String curp);
	
	@RequestMapping(value = "/domicilio/cadena/{cadena}", method = RequestMethod.GET)
	String findByDomiciliosCadenaCloud(@PathVariable String cadena);
	
	@RequestMapping(value = "/domicilio/datosPersonales/{nombre}/{primerApellido}/{segundoApellido}/{fechaNacimiento}/{sexo}/{entidad}" , method = RequestMethod.GET)
	String findByDomiciliosDatosPersonalesCloud(@PathVariable("nombre") String nombre, 
	@PathVariable("primerApellido") String primerApellido, 
	@PathVariable("segundoApellido") String segundoApellido, 
	@PathVariable("fechaNacimiento") String fechaNacimiento,
	@PathVariable("sexo") String sexo,  
	@PathVariable("entidad") Integer entidad);
}
