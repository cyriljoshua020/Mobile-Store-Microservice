package com.abc.orderservice.service;

import java.util.List;

import com.abc.orderservice.entity.Order;
import com.abc.orderservice.entity.OrderItem;
import com.abc.orderservice.model.Invoice;

public interface OrderService {
	
	Order placeOrder(int customerid,List<OrderItem> orderItems);
	
	Order getOrderDetails(int orderid);
	
	Invoice generateInvoice(int orderid);
}
