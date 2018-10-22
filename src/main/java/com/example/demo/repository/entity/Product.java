package com.example.demo.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
	private Long id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="description")
    private String description;
	
    /*
     * PARA EVITAR CICLOS INFINITOS EN MAPEOS SE UTILIZA LA ETIQUETA @JsonIgnore
     * ESTA ETIQUETA  IGNORA LOS OBJETOS Y NO LOS MUESTRA EN EL SERVICIO REST (OBJETOS JSON)
     * NO SE RECOMIENDA UTILIZAR LA ETIQUETA EN LA ENTIDAD.
     * SE RECOMIENDA UTILIZARLA EN CLASES DTO
     */
//    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idtype") 
    private ProductType productType;
	
	/**
	 * default constructor
	 */
	public Product () {
		
	}
	
	/**
	 * Constructor with parameters
	 * @param name
	 * @param description
	 * @param type
	 */
	public Product(String name, String description, ProductType productType) {
		this.name = name;
		this.description = description;
		this.productType = productType;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the productType
	 */
	public ProductType getProductType() {
		return productType;
	}

	/**
	 * @param productType the productType to set
	 */
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
}
