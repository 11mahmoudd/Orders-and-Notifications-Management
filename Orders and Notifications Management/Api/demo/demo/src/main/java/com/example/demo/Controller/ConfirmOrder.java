package com.example.demo.Controller;

import com.example.demo.Modules.Order;
import com.example.demo.Repo.OrderRepositry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConfirmOrder {
    private final OrderRepositry orderRepositry;
    public ConfirmOrder(OrderRepositry orderRepositry){
    this.orderRepositry = orderRepositry;
}
@GetMapping(value = "/SendSimpleMail/{code}")
public String ConfirmSimpleMail(@PathVariable("code")String code){
        System.out.println(orderRepositry.getSimpleOrders().peek().getCode());
    if (orderRepositry.getSimpleOrders().peek().getCode().equals(code)){
        orderRepositry.addMap2("Mail");
        orderRepositry.addMap(orderRepositry.getSimpleOrders().peek().getCustomer());
        return new SendNotificationController().SendSimpleMail(orderRepositry.getSimpleOrders());
    }
    return "";
}
    @GetMapping(value = "/SendCompoundMail/{code}")
    public String ConfirmCompoundMail(@PathVariable("code")String code){
        List<Order> orders= orderRepositry.getCompoundOrderOrders().peek();
        boolean check = false ;
        for (Order order :orders) {
            if (order.getCode().equals(code)){
                orderRepositry.addMap2("Mail");
                check = true ;
            }
        }
        if (check) {
            for (Order order : orders) {
                orderRepositry.addMap(order.getCustomer());
            }
            return new SendNotificationController().sendCompoundMail(orderRepositry.getCompoundOrderOrders());
        }
        return "";
    }

@GetMapping(value = "/SendSimpleSMS/{code}")
    public String ConfirmSMS(@PathVariable("code")String code){
        if (orderRepositry.getSimpleOrders().peek().getCode().equals(code)){
            orderRepositry.addMap2("SMS");
            orderRepositry.addMap(orderRepositry.getSimpleOrders().peek().getCustomer());
            return new SendNotificationController().SendSimpleSMS(orderRepositry.getSimpleOrders());
        }
        return "";
    }
    @GetMapping(value = "/SendCompoundSMS/{code}")
    public String ConfirmCompoundSMS(@PathVariable("code")String code){
        List<Order> orders= orderRepositry.getCompoundOrderOrders().peek();
        boolean check = false ;
        for (Order order :orders) {
            if (order.getCode().equals(code)){
                orderRepositry.addMap2("SMS");
                check = true ;
            }
        }
        if (check) {
            for (Order order : orders) {
                orderRepositry.addMap(order.getCustomer());
            }
            return new SendNotificationController().sendCompoundSMS(orderRepositry.getCompoundOrderOrders());
        }
        return "";
    }
}
