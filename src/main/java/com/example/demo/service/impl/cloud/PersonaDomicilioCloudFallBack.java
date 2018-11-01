package com.example.demo.service.impl.cloud;

import org.springframework.stereotype.Component;

import com.example.demo.service.cloud.IPersonaDomicilioCloud;

@Component
public class PersonaDomicilioCloudFallBack implements IPersonaDomicilioCloud {

	@Override
	public String findByDomiciliosCloud(String curp) {
		
		/*
		JSONObject json = new JSONObject();
		json.put("id", -1);
		json.put("fecha", "00/00/0000");
		json.put("cadena", "No encontrado");
		
		return json.toString();
		*/
		
		return "[{\"fecha\": \"00/00/0000\",\"cadena\": \"No encontrado\",\"id\": -1}]";
	}

}
