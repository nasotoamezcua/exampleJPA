package com.example.demo.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "name", "description", "productTypeDTO", "fechaConsulta"})
public class ProductDTO {
	
	@JsonProperty("id_product")
	private Long id;
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm a z", timezone = "America/Mexico_City")
	private Date fechaConsulta;
    private String name;
    private String description;
    @JsonIgnore
    private ProductTypeDTO productTypeDTO;
    
    
    public ProductDTO() {}
    
	public ProductDTO(Long id, Date fechaConsulta, String name, String description, ProductTypeDTO productTypeDTO) {
		super();
		this.id = id;
		this.fechaConsulta = fechaConsulta;
		this.name = name;
		this.description = description;
		this.productTypeDTO = productTypeDTO;
	}
	
	//Constructor para ProductTypeDTO
	public ProductDTO(Long id, Date fechaConsulta, String name, String description) {
		super();
		this.id = id;
		this.fechaConsulta = fechaConsulta;
		this.name = name;
		this.description = description;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ProductTypeDTO getProductTypeDTO() {
		return productTypeDTO;
	}
	public void setProductTypeDTO(ProductTypeDTO productTypeDTO) {
		this.productTypeDTO = productTypeDTO;
	}

}
