package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.convert.impl.ProductTypeConvert;
import com.example.demo.dto.ProductTypeDTO;
import com.example.demo.repository.entity.ProductType;
import com.example.demo.service.IProductTypeService;

@RestController
@RequestMapping(value = "/api")
public class ProductTypeRestController {
	
	private static final Logger log=  LoggerFactory.getLogger(ProductTypeRestController.class);
	
	@Autowired
	private IProductTypeService producTypeService;
	
	@Autowired
	private ProductTypeConvert productTypeConver;
	
	@GetMapping(value = "/productType", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<ProductType>> productTypeAll(){
		
		log.info("----- ProductTypeRestController :: productTypeAll -----");
		
		try {
			/* EN @RestController(JSON):
			 * ERROR 1: LOS MAPEOS BIDIRECCIONALES GENERAN CICLOS INFINITOS
			 * SOLCION: SE SOLUCIONA COLOCANDO EL TAG @JsonIgnore EN RELACION A LA QUE HACE REFERENCIA (Product).
			 * NOTA: EN MAPEOS @OneToMany(mappedBy = "productType", fetch = FetchType.LAZY)
			 * NO SE GENERA EL ERROR : JavassistLazyInitializer, PERO SE GENERAN MULTIPLES CONSULTAS, COMO UN FETCH=EAGER
			 * SOLCUION: SE SOLCIONA COLOCANDO @JsonIgnore EN LA ENTIDAD (ProductType).
			 * CONTRA: PERO ESTO OCASIONARA NO MOSTRAR LOS OBJETOS DE SU RELACION (Product)
			 * EN CASO DE QUE SE REQUIERAN MOSTRAR QUE HAGO?? 
			 * SOLUCION FINAL: LA SOLUCION ES GENERAR UN METODO CON UNA CONSULTA EXPLICITA.
			 * EJEMPLO:
			 * @Query("select distinct pt from ProductType pt join fetch pt.products p")
			 * List<ProductType> findAllLazyFetch();
			 * Y POSTERIORMENTE ELIMINAR EL TAG @JsonIgnore SOLO EN LA ENTIDAD (ProductType)
			 */
//			List<ProductType> listProductType= producTypeService.findAll();
			
			List<ProductType> listProductType= producTypeService.findAllLazyFetch();
			
			if(listProductType == null || listProductType.isEmpty()) {
				return new ResponseEntity<>(listProductType, HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<>(listProductType, HttpStatus.OK);
		}catch (Exception e) {
			log.error("Error en obtener todos los Tipos de Productos: {}", e.getMessage());
			return new ResponseEntity<>((List<ProductType>)null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/productType/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ProductType> productTypeFindById(@PathVariable("id") Long id){
		
		log.info("----- ProductTypeRestController :: productTypeFindById -----");
		
		try {
			ProductType productType = producTypeService.findById(id);
			
			if(productType == null) {
				return new ResponseEntity<>(productType, HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<ProductType>(productType, HttpStatus.OK);
		}catch (Exception e) {
			log.error("Error en obtener el Tipo de Producto {}: {}", id, e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * AL UTILIZAR DTO LOS METODOS QUE PROPORCIONA EL REPOSITORIO DE JPA 'findAll()', NO FUNCIONA EL MAPEO EN LAS ENTIDADES TIPO FETCH=LAZY 
	 * LAS INTERPRETA COMO TIPO FETCH=EAGER ESTO ES MALO YA QUE HIBERNATE GENERA MULTIPLES CONSUNTAS (UN MAL RENDIMIENTO EN LA APLICACION Y BD): 
	 * ES NECESARIO CREAR UN METODO QUE COTENGA UNA CONSULTA EXPLICITA 'findAllLazyFetch()' PARA QUE HIBERNATE SOLO GENERE UNA SOLO CONSULTA
	 * 
	 * @return
	 */
	
	/* EN @RestController(JSON) UTILIZANDO DTO LOS MAPEOS BIDIRECCIONALES UTILIZANDO LOS METODOS DEL REPOSITORIO (findAll()) DE JPA JpaRepository 
	 * NO GENERAN CICLOS INFINITOS, ESTO QUIERE DECIR QUE NO SE UTILIZA LOS TAG @JsonIgnore EN LAS ENTIDADES RELACIONADAS (Product y ProductType)
	 * CONTRA: PERO SI GENERAN MULTIPLES CONSULTAS, COMO SI FUERA UN TIPO FETCH=EAGER (NO RECOMENDADO)
	 * NOTA: EL TAG @JsonIgnore NO FUNCIONA, YA QUE SOLO QUITA EL OBJETO (ProductDTO) CON EL CUAL HACE REFERENCIA,
	 * PERO NO ELIMINA LA GENERACION DE MULTIPLES CONSULTAS, ADEMAS SE REQUIERE MOSTRAR LOS OBJETOS DE SU REFERENCIA (ProductDTO) POR LO TANTO EL TAG @JsonIgnore NO SIRVE.
	 * SOLUCION FINAL: 
	 * GENERAR UN METODO CON UNA CONSULTA EXPLICITA EJEMPLO:
	 * @Query("select distinct pt from ProductType pt join fetch pt.products p")
	 * List<ProductType> findAllLazyFetch();	
	 * Y POSTERIORMENTE ELIMINAR EL TAG @JsonIgnore SOLO EN LA ENTIDAD (ProductTypeDTO) PARA MOSTRAR LOS OBJETOS DE SU REFENCIA (ProductDTO).
	 * 
	 * SOLO GEGENERA UNA CONSULTA (RECOMENDADO)
	 * select product0_.id as id1_5_0_, 
	 * 	producttyp1_.id as id1_6_1_, 
	 * 	product0_.description as descript2_5_0_, 
	 * 	product0_.name as name3_5_0_, 
	 * 	product0_.idtype as idtype4_5_0_, 
	 * 	producttyp1_.name as name2_6_1_ 
	 * from product product0_ inner 
	 * 	join producttype producttyp1_ on product0_.idtype=producttyp1_.id
	 */
	@GetMapping(value = "/productTypeDTO", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<ProductTypeDTO>> productTypeDTOAll(){
		
		log.info("----- ProductTypeRestController :: productTypeDTOAll -----");
		
		try {
//			List<ProductType> listProductType= producTypeService.findAll();
			List<ProductType> listProductType= producTypeService.findAllLazyFetch();
			List<ProductTypeDTO> listProductTypeDTO = null;
			
			if(listProductType == null || listProductType.isEmpty()) {
				return new ResponseEntity<>(listProductTypeDTO, HttpStatus.NOT_FOUND);
			}
			
			listProductTypeDTO = productTypeConver.convertProductTypeDTO(listProductType);
			return new ResponseEntity<>(listProductTypeDTO, HttpStatus.OK);
			
		}catch (Exception e) {
			log.error("Error en obtener todos los Tipos de ProductosDTO: {}", e.getMessage());
			return new ResponseEntity<>((List<ProductTypeDTO>)null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
