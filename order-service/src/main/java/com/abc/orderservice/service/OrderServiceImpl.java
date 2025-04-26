package com.abc.orderservice.service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.abc.orderservice.entity.Order;
import com.abc.orderservice.entity.OrderItem;
import com.abc.orderservice.exception.ResourceNotFoundException;
import com.abc.orderservice.model.Customer;
import com.abc.orderservice.model.Invoice;
import com.abc.orderservice.model.Mobile;
import com.abc.orderservice.model.OrderItemModel;
import com.abc.orderservice.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orepo;
	
//	@Autowired
//	private RestTemplate restTemplate;
	
	@Autowired
	private CustomerApiClient customerApiClient;
	
	@Autowired
	private MobileApiClient mobileApiClient;
	
	@Override
	public Order placeOrder(int customerid, List<OrderItem> orderItems) {

		double ordertotal = 0;
		
		Order order = new Order();
		
		order.setOrderdate(LocalDate.now());
		order.setOrderstatus("pending");
		order.setCustomerid(customerid);
		
		for(OrderItem item: orderItems) {
			
			int mobileid = item.getMobileid();
			int qty = item.getQty();
			
//			ResponseEntity<Mobile> res = restTemplate.getForEntity("http://MOBILE-SERVICE/mobile/"+mobileid, Mobile.class);
//			
//			Mobile mobile = res.getBody();
			
			Mobile mobile = mobileApiClient.getMobileDetails(mobileid);
			
			double mobileprice = mobile.getPrice();
			
			
			//calculate orderItem total
			
			double itemtotal = mobileprice*qty;
			
			item.setItemtotal(itemtotal);
			
			ordertotal = ordertotal + itemtotal;
			
			item.setOrder(order);
			 
		}
		
		order.setOrderitems(orderItems);
		
		order.setOrderamount(ordertotal);
		
		orepo.save(order);
		
		return order;
	}

	@Override
	public Order getOrderDetails(int orderid) {
		
		Optional<Order> optionalOrder = orepo.findById(orderid);
		if(optionalOrder.isEmpty()) {
			throw new ResourceNotFoundException("Order not found");
		}
		Order order = optionalOrder.get();
		
		return order;
	}

	@Override
	public Invoice generateInvoice(int orderid) {
		
		Order order = getOrderDetails(orderid);
		
		Invoice invoice = new Invoice();
		invoice.setOrderid(order.getOrderid());
		invoice.setOrderdate(order.getOrderdate());
		invoice.setOrderamount(order.getOrderamount());
		invoice.setOrderstatus(order.getOrderstatus());
		
		int customerid = order.getCustomerid();
		
//		ResponseEntity<Customer> res = restTemplate.getForEntity("http://CUSTOMER-SERVICE/customer/"+customerid, Customer.class);
//		Customer customer = res.getBody();
		
		Customer customer = customerApiClient.getCustomerDetails(customerid);
		
		invoice.setCustomer(customer);
		
		List<OrderItem> orderEntityItems = order.getOrderitems();
		
		List<OrderItemModel> orderItems = new ArrayList<>();
		
		for(OrderItem entityItem: orderEntityItems) {
			OrderItemModel orderItemModel = new OrderItemModel();
			orderItemModel.setItemid(entityItem.getOrderitemid());
			orderItemModel.setItemtotal(entityItem.getItemtotal());
			orderItemModel.setQty(entityItem.getQty());
			
			int mobileId = entityItem.getMobileid();
			
//            ResponseEntity<Mobile> mobres = restTemplate.getForEntity("http://MOBILE-SERVICE/mobile/"+mobileId, Mobile.class);
//			
//			Mobile mobile = mobres.getBody();
			
			Mobile mobile = mobileApiClient.getMobileDetails(mobileId);
			
			orderItemModel.setMobile(mobile);
			orderItems.add(orderItemModel);
			
		}
		
		invoice.setOrderitems(orderItems);
		
		return invoice;
	}

}

