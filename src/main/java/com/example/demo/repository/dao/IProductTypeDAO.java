package com.example.demo.repository.dao;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import com.example.demo.repository.entity.ProductType;

public interface IProductTypeDAO extends JpaRepository<ProductType, Long> {
	
	/**
	 * PARA RECUPERAR TODOS LOS 'ProductType' CON SUS RESPETIVOS 'Products' TENIENDO EN LA '@Entity @OneToMany(mappedBy = "productType", fetch = FetchType.LAZY)'
	 * ES NECESARIO UTILIZAR UNA CONSULTA EXPLICITA UTILIZANDO UN join fetch: 
	 * '@Query("select distinct pt from ProductType pt join fetch pt.products p")'
	 * PARA EVITAR DUPLICADOS SE UTILIZA LA PALABRA DISTINCT
	 * PERO ESTO ES UN ANTI PATRON YA QUE CAUSA PROBLEMAS DE RENDIMEIENTO EN LA BASE DE DATOS
	 * http://in.relation.to/2016/08/04/introducing-distinct-pass-through-query-hint/
	 * PARA SOLUCIONAR EL PROBLEMA DEL ANTIPATRON UTILIZAREMOS EL SIGUIENTE TAG: 
	 * '@QueryHints(value = @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_PASS_DISTINCT_THROUGH, value = "false"))'
	 * ESTO QUITA LOS DUPLICADOS, PERO INTERNAMENTE EN LA CONSULTA QUE GENERA HIBERNATE, ELIMINA LA PALABRA RESERVADA 'distinct'
	 * SOLUCIONANDO EL PROBLEMA DEL ANTIPATRON
	 * 
	 * @return
	 */
	
	@Query("select distinct pt from ProductType pt join fetch pt.products p")
	@QueryHints(value = @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_PASS_DISTINCT_THROUGH, value = "false"))
	List<ProductType> findAllLazyFetch();

}
