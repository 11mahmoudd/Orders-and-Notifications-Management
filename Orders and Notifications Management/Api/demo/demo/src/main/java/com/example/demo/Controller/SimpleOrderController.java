package com.example.demo.Controller;


import com.example.demo.Modules.Customer;
import com.example.demo.Modules.Order;
import com.example.demo.Repo.CustomerRepositry;
import com.example.demo.Repo.OrderRepositry;
import com.example.demo.Repo.ProductRepositry;
import com.example.demo.Request.ObjectRequest;
import com.example.demo.bsi.SimpleOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Queue;

@RestController
public class SimpleOrderController {
    private SimpleOrder simpleOrder;
    private final ProductRepositry productRepositry ;
    private final CustomerRepositry customerRepositry;
    private final OrderRepositry orderRepositry ;

    public SimpleOrderController(ProductRepositry productRepositry , CustomerRepositry customerRepositry, OrderRepositry orderRepositry) {
        simpleOrder = new SimpleOrder();
        this.customerRepositry = customerRepositry;
        this.productRepositry=productRepositry;
        this.orderRepositry = orderRepositry;
    }

    public SimpleOrder getSimpleOrder() {
        return simpleOrder;
    }
    public void add(OrderRepositry orderRepositry,Order order) {
        simpleOrder.add(orderRepositry,order);
    }
    @PostMapping(value = "/SimpleOrder")
    public String MakeOrder(@RequestBody ObjectRequest request) {
        Customer customer =customerRepositry.getCustomer(request.getName());
        Order order = simpleOrder.MakeOrder(customer , request.getList(),request.getAddress(),productRepositry.getProducts() , request.getQuantity());
        add(orderRepositry,order);
        return order.getCode();
    }
}