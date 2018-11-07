package com.example.demo.service.cloud;

import java.util.List;

import com.example.demo.dto.PersonaSeisDPDTO;
import com.example.demo.dto.cloud.PersonaDomicilioDTO;

import feign.FeignException;

public interface IPersonaDomicilioService {
	
	List<PersonaDomicilioDTO> findByDomiciliosCurpService(String curp) throws FeignException;
	
	List<PersonaDomicilioDTO> findByDomiciliosCadenaService(String cadena) throws FeignException;
	
	List<PersonaDomicilioDTO> findByDomiciliosDatosPersonalesService(PersonaSeisDPDTO personaSeisDPDTO) throws FeignException;

}
