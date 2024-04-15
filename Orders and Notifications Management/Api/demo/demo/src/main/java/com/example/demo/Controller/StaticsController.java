package com.example.demo.Controller;

import com.example.demo.Modules.Customer;
import com.example.demo.Repo.OrderRepositry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaticsController {
    private final OrderRepositry orderRepositry ;

    public StaticsController(OrderRepositry orderRepositry){
        this.orderRepositry = orderRepositry ;

    }
    @GetMapping(value = "/MaxNotified")
    public Customer MaxNotified(){
        return orderRepositry.getMostNotified();
    }
    @GetMapping(value = "/MaxTemplate")
    public String MaxTemplate(){
        return orderRepositry.getMostNotificationTemplate();
    }

}
