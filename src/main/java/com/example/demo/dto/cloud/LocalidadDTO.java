package com.example.demo.dto.cloud;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LocalidadDTO {
	
	private Integer id;
	private String nombre;
	@JsonProperty("tipoLocalidad")
	private TipoLocalidadDto tipoLocalidadDto;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public TipoLocalidadDto getTipoLocalidadDto() {
		return tipoLocalidadDto;
	}
	public void setTipoLocalidadDto(TipoLocalidadDto tipoLocalidadDto) {
		this.tipoLocalidadDto = tipoLocalidadDto;
	}

}
