package com.example.demo.service.cloud.impl;

import org.springframework.stereotype.Component;

import com.example.demo.service.cloud.IPersonaDomicilioCloud;

@Component
public class PersonaDomicilioCloudFallBack implements IPersonaDomicilioCloud {

	/**
	 * Busqueda por curp FallBack 
	 */
	@Override
	public String findByDomiciliosCurpCloud(String curp) {
		
		/*
		JSONObject json = new JSONObject();
		json.put("id", -1);
		json.put("fecha", "00/00/0000");
		json.put("cadena", "No encontrado");
		
		return json.toString();
		*/
		
		return this.findByDomiciliosCloud(curp,1);
	}
	
	/**
	 * Busqueda por cadena FallBack
	 */
	@Override
	public String findByDomiciliosCadenaCloud(String cadena) {
		// TODO Auto-generated method stub
		return this.findByDomiciliosCloud(cadena,2);
	}
	
	/**
	 * Busqueda por datos personales FallBack
	 */
	@Override
	public String findByDomiciliosDatosPersonalesCloud(String nombre, String primerApellido, String segundoApellido,
			String fechaNacimiento, String sexo, Integer entidad) {
		// TODO Auto-generated method stub
		String opcion = nombre + " " + primerApellido + " " + segundoApellido + " " + fechaNacimiento + " " + sexo + " " + entidad;
		return this.findByDomiciliosCloud(opcion,3);
	}
	
	/**
	 * Respuesta por curp, cadena y datos personales FallBack
	 * @param opcion
	 * @param id
	 * @return
	 */
	private String findByDomiciliosCloud(String opcion, int id) {
		String respuestaJSON = null;
		switch (id) {
		case 1:
			respuestaJSON = "[{\"fecha\": \"00/00/0000\",\"cadena\": \"No encontrado\",\"id\": -1,\"mensaje\": \"Servicio no encontrado al ingresar curp: "+ opcion+" \"}]";
			break;
		case 2:
			respuestaJSON = "[{\"fecha\": \"00/00/0000\",\"cadena\": \"No encontrado\",\"id\": -1,\"mensaje\": \"Servicio no encontrado al ingresar cadena: "+ opcion+" \"}]";
			break;
		
		case 3:
			respuestaJSON = "[{\"fecha\": \"00/00/0000\",\"cadena\": \"No encontrado\",\"id\": -1,\"mensaje\": \"Servicio no encontrado al ingresar Datos Personales: "+ opcion +" \"}]";
			break;

		default:
			respuestaJSON = "[{\"fecha\": \"00/00/0000\",\"cadena\": \"No encontrado\",\"id\": -1,\"mensaje\": \"Servicio no encontrado\"}]";
			break;
		}
		return respuestaJSON;
	}

}
