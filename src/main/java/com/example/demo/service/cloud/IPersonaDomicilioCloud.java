package com.example.demo.service.cloud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.service.impl.cloud.PersonaDomicilioCloudFallBack;

@FeignClient(name = "domicilios-api", fallback = PersonaDomicilioCloudFallBack.class)
public interface IPersonaDomicilioCloud {
	
	@RequestMapping(value = "/domicilio/curp/{curp}", method = RequestMethod.GET)
	String findByDomiciliosCloud(@PathVariable String curp);
}
