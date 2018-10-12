package com.example.demo.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ProductTypeDTO {
	
	private Long id;
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm a z", timezone = "America/Mexico_City")
	private Date fechaConsulta;
	private String name;
	private List<ProductDTO> productsDTO;
	
	
	public ProductTypeDTO(Long id, Date fechaConsulta, String name, List<ProductDTO> productsDTO) {
		super();
		this.id = id;
		this.fechaConsulta = fechaConsulta;
		this.name = name;
		this.productsDTO = productsDTO;
	}
	
	//Constructor para ProductDTO
	public ProductTypeDTO(Long id, Date fechaConsulta, String name) {
		super();
		this.id = id;
		this.fechaConsulta = fechaConsulta;
		this.name = name;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getFechaConsulta() {
		return fechaConsulta;
	}


	public void setFechaConsulta(Date fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<ProductDTO> getProductsDTO() {
		return productsDTO;
	}


	public void setProductsDTO(List<ProductDTO> productsDTO) {
		this.productsDTO = productsDTO;
	}
}
