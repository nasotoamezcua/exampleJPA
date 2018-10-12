package com.example.demo.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ProductTypeAllDTO {
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Mexico_City")
	private Date fechaConsulta;
	private Long idProductType;
	private String nameProductType;
	private Long idProduct;
    private String nameProduct;
    private String descriptionProduct;
    
    
	public ProductTypeAllDTO(Date fechaConsulta, Long idProductType, String nameProductType, Long idProduct,
			String nameProduct, String descriptionProduct) {
		super();
		this.fechaConsulta = fechaConsulta;
		this.idProductType = idProductType;
		this.nameProductType = nameProductType;
		this.idProduct = idProduct;
		this.nameProduct = nameProduct;
		this.descriptionProduct = descriptionProduct;
	}


	public Date getFechaConsulta() {
		return fechaConsulta;
	}


	public void setFechaConsulta(Date fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}


	public Long getIdProductType() {
		return idProductType;
	}


	public void setIdProductType(Long idProductType) {
		this.idProductType = idProductType;
	}


	public String getNameProductType() {
		return nameProductType;
	}


	public void setNameProductType(String nameProductType) {
		this.nameProductType = nameProductType;
	}


	public Long getIdProduct() {
		return idProduct;
	}


	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}


	public String getNameProduct() {
		return nameProduct;
	}


	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}


	public String getDescriptionProduct() {
		return descriptionProduct;
	}


	public void setDescriptionProduct(String descriptionProduct) {
		this.descriptionProduct = descriptionProduct;
	}
}
