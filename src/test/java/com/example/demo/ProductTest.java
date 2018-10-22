package com.example.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.repository.dao.IProductDAO;
import com.example.demo.repository.dao.IProductTypeDAO;
import com.example.demo.repository.entity.Product;
import com.example.demo.repository.entity.ProductType;
import com.example.demo.service.IProductService;
import com.example.demo.service.IProductTypeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTest {
	
	@Autowired
	IProductService productService;
	
	@Autowired
	IProductTypeService productTypeService;
	
	@Autowired
	IProductDAO productDao;
	
	@Autowired
	IProductTypeDAO productTypeDao;
	
	/**
	 * EN CONSOLA FUNCIONA CORRECTAMENTE EL MAPEO EN LAS ENTIDADES TIPO FETCH=LAZY  
	 * UTILIZANDO LOS METODOS PROPORCIONADOS POR EL REPOSITORIO DE JPA 'findAll()'
	 * SOLO SE TRAE EL OBJETO SIN SUS RELACIONES
	 * 
	 * SI SE REQUIERE TRAER LOS OBJETOS DE SU RELACION
	 * SE NECESITA CAMBIAR EL MAPEO DE LAS ENTIDADES DE TIPO FETCH=LAZY A TIPO FETCH=EAGER (NO RECOMENDADO AFECTA RENDIMIENTO EN APLICACION y BD)
	 * LA SOLUCION RECOMENDADA ES CREAR UNA CONSULTA EXPLICITA UTILIZANSO 'JOIN FETCH' EN UN METODO DEFINIDO, EN ESTE CASO 'findAllLazyFetch()'
	 */
	
	@Test
	public void productAllTest() {
		try {
			List<Product> listProduct = productService.findAll();
			if(listProduct != null) {
				for(Product p : listProduct) {
					System.out.println(p);
					System.out.println(p.getProductType().getId() + " " + p.getProductType().getName());
					
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	@Test
	public void productAllFetchTest() {
		try {
			List<Product> listProduct = productDao.findAllLazyFetch();
			if(listProduct != null) {
				for(Product p : listProduct) {
					System.out.println(p);
					System.out.println(p.getProductType().getId() + " " + p.getProductType().getName());
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	@Test
	public void productTypeAllTest() {
		try {
			List<ProductType> listProductType = productTypeService.findAll();
			if(listProductType != null) {
				for(ProductType pt : listProductType) {
					System.out.println(pt);
					for(Product p : pt.getProducts()) {
						System.out.println(p.getId() + " " + p.getName());
					}
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	@Test
	public void productTypeAllFetchTest() {
		try {
			List<ProductType> listProductType = productTypeDao.findAllLazyFetch();
			if(listProductType != null) {
				for(ProductType pt : listProductType) {
					System.out.println(pt);
					for(Product p : pt.getProducts()) {
						System.out.println(p.getId() + " " + p.getName());
					}
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
