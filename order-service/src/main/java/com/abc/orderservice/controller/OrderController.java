package com.abc.orderservice.controller;

import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abc.orderservice.entity.Order;
import com.abc.orderservice.entity.OrderItem;
import com.abc.orderservice.model.Invoice;
import com.abc.orderservice.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
    
    @Autowired
    private Environment env;  
    
    @Autowired
    private OrderService oservice;
    
    @PostMapping("/create/{customerid}")
    public ResponseEntity<Order> createOrder(@PathVariable int customerid, @RequestBody List<OrderItem> orderItems) {
        Order order = oservice.placeOrder(customerid, orderItems);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
    
    @GetMapping("/{orderid}")
    public ResponseEntity<Order> getOrderDetails(@PathVariable int orderid) {
        Order order = oservice.getOrderDetails(orderid);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
    
    @GetMapping("/invoice/{orderid}")
    public ResponseEntity<Invoice> createInvoice(@RequestParam("order_id") int orderid) {  
        
        Invoice invoiceDto = oservice.generateInvoice(orderid);  
        
        System.out.println("Customer Service Running on port: " + env.getProperty("server.port")); 
        
        return new ResponseEntity<>(invoiceDto, HttpStatus.OK);
    }
}
