package com.example.demo.dto.cloud;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AsentamientoDTO {
	
	private Integer id;
	private String nombre;
	@JsonProperty("tipoAsentamiento")
	private TipoAsentamientoDTO tipoAsentamientoDto;
	
	
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
	public TipoAsentamientoDTO getTipoAsentamientoDto() {
		return tipoAsentamientoDto;
	}
	public void setTipoAsentamientoDto(TipoAsentamientoDTO tipoAsentamientoDto) {
		this.tipoAsentamientoDto = tipoAsentamientoDto;
	}

}
