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
import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.ProductTypeAllDTO;
import com.example.demo.repository.entity.Product;
import com.example.demo.service.IProductService;

@RestController
@RequestMapping(value = "/api")
public class PropductRestController {
	
	private static final Logger log=  LoggerFactory.getLogger(PropductRestController.class);
	
	@Autowired
	private IProductService productService;
	
	@Autowired
	private ProductTypeConvert productConver;
	
	@GetMapping(value="/product", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Product>> productAll(){
		
		log.info("----- PropductRestController :: productAll -----");
		
		try {
			
			/* EN @RestController(JSON): 
			 * ERROR 1: LOS MAPEOS BIDIRECCIONALES UTILIZANDO LOS METODOS DEL REPOSITORIO (findAll()) DE JPA JpaRepository GENERAN CICLOS INFINITOS
			 * SOLCION: SE SOLUCIONA COLOCANDO EL TAG @JsonIgnore EN RELACION A LA QUE HACE REFERENCIA (ProductType). 
			 * ERROR 2: EN MAPEOS @ManyToOne FETCH=LAZY findAll() 
			 * SE GENERA ERROR: JavassistLazyInitializer, (SE GENERAN MULTIPLES CONSULTAS, COMO UN TIPO FETCH=EAGER)
			 * SOLCUION: SE SOLCIONA COLOCANDO @JsonIgnore EN LA ENTIDAD (Product).
			 * CONTRA: PERO ESTO OCASIONARA NO MOSTRAR LOS OBJETOS DE SU RELACION (ProductType)
			 * EN CASO DE QUE SE REQUIERAN MOSTRAR QUE HAGO?? 
			 * SOLUCION FINAL: LA SOLUCION ES GENERAR UN METODO CON UNA CONSULTA EXPLICITA.
			 * EJEMPLO: 
			 * @Query("select p from Product p join fetch p.productType t")
			 * List<Product> findAllLazyFetch();
			 * Y POSTERIORMENTE ELIMINAR EL TAG @JsonIgnore SOLO EN LA ENTIDAD (Product)
			 */
//			List<Product> listProduct = productService.findAll(); 
			List<Product> listProduct = productService.findAllLazyFetch();
			if(listProduct == null || listProduct.isEmpty()) {
				return new ResponseEntity<>(listProduct, HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<>(listProduct, HttpStatus.OK);
		}catch (Exception e) {
			log.error("Error en obtener todos los Productos: {}", e.getMessage());
			return new ResponseEntity<>((List<Product>)null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/product/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Product> productFindById(@PathVariable(name = "id") Long id){
		log.info("----- PropductRestController :: productFindById -----");
		
		try {
			Product product = productService.findById(id);
			if(product == null) {
				return new ResponseEntity<>(product, HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<>(product, HttpStatus.OK);
		}catch (Exception e) {
			log.error("Error en obtener el Producto {}: {}", id, e.getMessage());
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
	 * NOTA: EL TAG @JsonIgnore NO FUNCIONA, YA QUE SOLO QUITA EL OBJETO (ProductTypeDTO) CON EL CUAL HACE REFERENCIA,
	 * PERO NO ELIMINA LA GENERACION DE MULTIPLES CONSULTAS, ADEMAS SE REQUIERE MOSTRAR LOS OBJETOS DE SU REFERENCIA (ProductTypeDTO) POR LO TANTO EL TAG @JsonIgnore NO SIRVE.
	 * SOLUCION FINAL: 
	 * GENERAR UN METODO CON UNA CONSULTA EXPLICITA EJEMPLO:
	 * @Query("select p from Product p join fetch p.productType t") (EL MISMO QUE SE GENERO PARA LA ENTIDAD Product)
	 * List<Product> findAllLazyFetch();
	 * Y POSTERIORMENTE ELIMINAR EL TAG @JsonIgnore SOLO EN LA ENTIDAD (ProductDTO) PARA MOSTRAR LOS OBJETOS DE SU REFENCIA (ProductTypeDTO).
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
	@GetMapping(value = "/productDTO" , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<ProductDTO>> productDTOAll(){
		
		log.info("----- PropductRestController :: productDTOAll -----");
		
		try {
			
			
//			List<Product> listProduct = productService.findAll();
			List<Product> listProduct = productService.findAllLazyFetch();
			List<ProductDTO> listProductDTO = null;
			
			if(listProduct == null || listProduct.isEmpty()) {
				return new ResponseEntity<>(listProductDTO,HttpStatus.NOT_FOUND);
			}
			
			listProductDTO = productConver.converProductDTO(listProduct);
			return new ResponseEntity<>(listProductDTO, HttpStatus.OK);
			
		}catch (Exception e) {
			log.error("Error en obtener todos los ProductosDTO: {}", e.getMessage());
			return new ResponseEntity<>((List<ProductDTO>)null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * AL UTILIZAR DTO LOS METODOS QUE PROPORCIONA EL REPOSITORIO DE JPA 'findAll()', NO FUNCIONA EL MAPEO EN LAS ENTIDADES TIPO FETCH=LAZY 
	 * LAS INTERPRETA COMO TIPO FETCH=EAGER ESTO ES MALO YA QUE HIBERNATE GENERA MULTIPLES CONSUNTAS (UN MAL RENDIMIENTO EN LA APLICACION Y BD): 
	 * ES NECESARIO CREAR UN METODO QUE COTENGA UNA CONSULTA EXPLICITA 'findAllLazyFetch()' PARA QUE HIBERNATE SOLO GENERE UNA SOLO CONSULTA
	 * 
	 * @return
	 */
	
	/*
	 * GENERA MULTIPLES CONSULTAS (NO RECOMENDADO)
	 * select product0_.id as id1_5_, 
	 * 	product0_.description as descript2_5_, 
	 * 	product0_.name as name3_5_, 
	 * 	product0_.idtype as idtype4_5_ 
	 * from product product0_
	 * 
	 * select producttyp0_.id as id1_6_0_, 
	 * 	producttyp0_.name as name2_6_0_ 
	 * from producttype producttyp0_ where producttyp0_.id=?
     * 
     * select producttyp0_.id as id1_6_0_, 
     * 	producttyp0_.name as name2_6_0_ 
     * from producttype producttyp0_ where producttyp0_.id=?

	 */
	@GetMapping(value = "/productTypeAllDTO" , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<ProductTypeAllDTO>> productTypeAllDTOAll(){
		
		log.info("----- PropductRestController :: productTypeAllDTOAll -----");
		
		try {
			List<Product> listProduct = productService.findAll();
//			List<Product> listProduct = productService.findAllLazyFetch();
			List<ProductTypeAllDTO> listProductTypeAllDTO = null;
			
			if(listProduct == null || listProduct.isEmpty()) {
				return new ResponseEntity<>(listProductTypeAllDTO,HttpStatus.NOT_FOUND);
			}
			
			listProductTypeAllDTO = productConver.convertProductTypeAllDTO(listProduct);
			return new ResponseEntity<>(listProductTypeAllDTO, HttpStatus.OK);
			
		}catch (Exception e) {
			log.error("Error en obtener todos los ProductosDTO: {}", e.getMessage());
			return new ResponseEntity<>((List<ProductTypeAllDTO>)null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
