package com.example.demo.repository.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "producttype")
public class ProductType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;
	 
	/*
     * PARA EVITAR CICLOS INFINITOS EN MAPEOS SE UTILIZA LA ETIQUETA @JsonIgnore
     * ESTA ETIQUETA  IGNORA LOS OBJETOS Y NO LOS MUESTRA EN EL SERVICIO REST (OBJETOS JSON)
     * NO SE RECOMIENDA UTILIZAR LA ETIQUETA EN LA ENTIDAD.
     * SE RECOMIENDA UTILIZARLA EN CLASES DTO
     */
    @JsonIgnore
	@OneToMany(mappedBy = "productType", fetch = FetchType.EAGER)
	private Set<Product> products = new HashSet<Product>();

	/**
	 * Default constructor
	 */
	public ProductType() {

	}

	/**
	 * Constructor with parameters
	 * @param name
	 */
	public ProductType(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
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
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the products
	 */
	public Set<Product> getProducts() {
		return products;
	}

	/**
	 * @param products
	 *            the products to set
	 */
	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	/**
	 * Añade un producto a la lista de productos
	 * 
	 * @param product
	 */
	public void addProduct(Product product) {
		this.products.add(product);
	}

	/*
	 * SI SE AGREGA LA PROPIEDAD "products" AL METOO toString().
	 * EN SU CLASE DE MAPEO BIDIRECCIONAL "products" 
	 * SU METODO toString() YA NO DEBE DE CONTENER SU PROPIEDAD productType DE LA CLASE ProductType
	 * ESTO OCASIONARIA UN MAPEO INFINITO Y VUELCA LA MEMORIA
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProductType [id=" + id + ", name=" + name + ", products=" + products + "]";
	}
}
