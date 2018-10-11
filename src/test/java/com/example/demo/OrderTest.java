package com.example.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.repository.entity.Order;
import com.example.demo.repository.entity.OrderItems;
import com.example.demo.service.IOrderItemsService;
import com.example.demo.service.IOrderService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTest {
	
	@Autowired
	IOrderService orderService;
	
	@Autowired
	IOrderItemsService orderItemService;
	
	@Test
	public void orderAll() {
		try {
			List<Order> listOrder = orderService.findAll();
			if(listOrder != null && listOrder.size()>0) {
				for(Order o : listOrder) {
					System.out.println(o);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void orderItemByOrderId() {
		try {
			System.out.println("----- orderItemByOrderId -----");
			List<OrderItems> listOrderItems = orderItemService.findByOrderId(1L);
			if(listOrderItems != null && listOrderItems.size()>0) {
				for(OrderItems oi : listOrderItems) {
					System.out.println(oi);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
