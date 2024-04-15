package com.example.demo.Controller;

import com.example.demo.Modules.Order;
import com.example.demo.Repo.CustomerRepositry;
import com.example.demo.Repo.OrderRepositry;
import com.example.demo.Repo.ProductRepositry;
import com.example.demo.bsi.Shipping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ShippingController {

private Shipping shipping ;
    private final ProductRepositry productRepositry ;
    private final CustomerRepositry customerRepositry ;
    private final OrderRepositry orderRepositry ;
    public ShippingController(ProductRepositry productRepositry , CustomerRepositry customerRepositry , OrderRepositry orderRepositry){
    this.customerRepositry = customerRepositry ;
    this.orderRepositry= orderRepositry;
    this.productRepositry = productRepositry;
    shipping = new Shipping();
    }
    @GetMapping (value = "/SimpleShipping")
    public String SimpleShipping(){
        Order order = orderRepositry.getSimpleOrders().peek();
        customerRepositry.getCustomer(order.getCustomer().getUsername()).setBalance(customerRepositry.getCustomer(order.getCustomer().getUsername()).getBalance() - order.getPrice() + (order.getPrice() * 0.26));
        return shipping.SimpleShipping(orderRepositry.getSimpleOrders());
    }
    @GetMapping (value = "/CompShipping")
    public String CompShipping(){
        List<Order> list = orderRepositry.getCompoundOrderOrders().peek();
        for (Order order :list){
            customerRepositry.getCustomer(order.getCustomer().getUsername()).setBalance(customerRepositry.getCustomer(order.getCustomer().getUsername()).getBalance() - order.getPrice() + (order.getPrice() * 0.26));
        }
        return shipping.CompShipping(orderRepositry.getCompoundOrderOrders());
    }
}
