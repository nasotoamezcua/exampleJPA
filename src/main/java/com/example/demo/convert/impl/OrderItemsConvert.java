package com.example.demo.convert.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.OrderDTO;
import com.example.demo.dto.OrderItemsFullDTO;
import com.example.demo.dto.OrderItemsProductInfoDTO;
import com.example.demo.dto.OrderOrganizadoDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.repository.entity.OrderItems;

@Component
public class OrderItemsConvert{

	
	/**
	 * GENERAR DTO converOrderItemsFull
	 * @param mapping
	 * @return
	 */
	public OrderItemsFullDTO converOrderItemsFull(List<OrderItems> mapping) {
		
		OrderItemsFullDTO oif = null;
		List<OrderItemsProductInfoDTO> listPiidto = null;
		
		if(mapping != null) {
			oif = new OrderItemsFullDTO();
			listPiidto = new ArrayList<OrderItemsProductInfoDTO>();
			// ORDER
			oif.setId_order(mapping.get(0).getOrder().getId());
			oif.setOrderTotal(mapping.get(0).getOrder().getOrderTotal());
			oif.setOrderTimestamp(mapping.get(0).getOrder().getOrderTimestamp());
			
			for(int i=0; i<mapping.size();i++) {
				OrderItemsProductInfoDTO piidto = new OrderItemsProductInfoDTO(mapping.get(i).getId(), 
						mapping.get(i).getQuantity(), 
						mapping.get(i).getUnitPrice(), 
						mapping.get(i).getProductInfo().getId(), 
						mapping.get(i).getProductInfo().getProductName(), 
						mapping.get(i).getProductInfo().getProductDescription(), 
						mapping.get(i).getProductInfo().getCategory(), 
						mapping.get(i).getProductInfo().getProductAvail());
				
				listPiidto.add(piidto);
			}
			
			oif.setOrderItemsProductInfoDTO(listPiidto);
			
			//CUSTOMER
			oif.setId_customer(mapping.get(0).getOrder().getCustomer().getId());
			oif.setCustFirstName(mapping.get(0).getOrder().getCustomer().getCustFirstName());
			oif.setCustLastName(mapping.get(0).getOrder().getCustomer().getCustLastName());
			oif.setCustStreetName(mapping.get(0).getOrder().getCustomer().getCustStreetName());
			oif.setCustCity(mapping.get(0).getOrder().getCustomer().getCustCity());
			oif.setCustState(mapping.get(0).getOrder().getCustomer().getCustState());
			oif.setCustPostalCode(mapping.get(0).getOrder().getCustomer().getCustPostalCode());
			oif.setPhoneNumber(mapping.get(0).getOrder().getCustomer().getPhoneNumber());
			oif.setCreditLimit(mapping.get(0).getOrder().getCustomer().getCreditLimit());
			//USER
			oif.setId_user(mapping.get(0).getOrder().getUser().getId());
			oif.setUserName(mapping.get(0).getOrder().getUser().getUserName());
			oif.setPassword(mapping.get(0).getOrder().getUser().getPassword());
			oif.setCreateOn(mapping.get(0).getOrder().getUser().getCreateOn());			
		}
		return oif;
	}
	
	
	/**
	 * GENERAR DTO converOrderItemsOrganizado
	 * @param mapping
	 * @return
	 */
	public OrderOrganizadoDTO converOrderItemsOrganizado(List<OrderItems> mapping) {
		
		OrderOrganizadoDTO ood = null;
		List<OrderItemsProductInfoDTO> listPiidto = null;
		
		if(mapping != null) {
			try {
				listPiidto = new ArrayList<OrderItemsProductInfoDTO>();
				OrderDTO orderDto = new OrderDTO(mapping.get(0).getOrder().getId(), 
						mapping.get(0).getOrder().getOrderTotal(), 
						mapping.get(0).getOrder().getOrderTimestamp());

				for(int i=0; i<mapping.size();i++) {
					OrderItemsProductInfoDTO piidto = new OrderItemsProductInfoDTO(mapping.get(i).getId(), 
							mapping.get(i).getQuantity(), 
							mapping.get(i).getUnitPrice(), 
							mapping.get(i).getProductInfo().getId(), 
							mapping.get(i).getProductInfo().getProductName(), 
							mapping.get(i).getProductInfo().getProductDescription(), 
							mapping.get(i).getProductInfo().getCategory(), 
							mapping.get(i).getProductInfo().getProductAvail());
					
					listPiidto.add(piidto);
				}
				
				CustomerDTO customerDto = new CustomerDTO(mapping.get(0).getOrder().getCustomer().getId(), 
												mapping.get(0).getOrder().getCustomer().getCustFirstName(), 
												mapping.get(0).getOrder().getCustomer().getCustLastName(), 
												mapping.get(0).getOrder().getCustomer().getCustStreetName(), 
												mapping.get(0).getOrder().getCustomer().getCustCity(), 
												mapping.get(0).getOrder().getCustomer().getCustState(), 
												mapping.get(0).getOrder().getCustomer().getCustPostalCode(), 
												mapping.get(0).getOrder().getCustomer().getPhoneNumber(), 
												mapping.get(0).getOrder().getCustomer().getCreditLimit());
				
				UserDTO userDto = new UserDTO(mapping.get(0).getOrder().getUser().getId(), 
										mapping.get(0).getOrder().getUser().getUserName(), 
										mapping.get(0).getOrder().getUser().getPassword(), 
										mapping.get(0).getOrder().getUser().getCreateOn());
				
				
				ood = new OrderOrganizadoDTO(orderDto, listPiidto, customerDto, userDto);
				
			}catch (Exception e) {
				e.getMessage();
			}
		}
		
		return ood;
	}

}
