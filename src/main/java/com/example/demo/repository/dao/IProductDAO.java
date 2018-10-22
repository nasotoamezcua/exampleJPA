package com.example.demo.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.repository.entity.Product;

public interface IProductDAO extends JpaRepository<Product, Long> {
	
	/**
	 * PARA RECUPERAR TODOS LOS 'Product' CON SUS RESPETIVOS 'ProductType' TENIENDO EN LA '@Entity @ManyToOne(fetch = FetchType.LAZY)'
	 * ES NECESARIO UTILIZAR UNA CONSULTA EXPLICITA UTILIZANDO UN join fetch: 
	 * '@Query("select p from Product p join fetch p.productType t")'
	 * 
	 * @return
	 */
	
	@Query("select p from Product p join fetch p.productType t")
	List<Product> findAllLazyFetch();
	
}
