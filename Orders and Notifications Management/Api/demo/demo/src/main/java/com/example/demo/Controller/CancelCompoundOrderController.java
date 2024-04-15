package com.example.demo.Controller;


import com.example.demo.Modules.Order;
import com.example.demo.Repo.OrderRepositry;
import com.example.demo.bsi.CancelCompoundOrder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class CancelCompoundOrderController {
    private CancelCompoundOrder compoundOrder;
    private final OrderRepositry orderRepositry ;
    public CancelCompoundOrderController(OrderRepositry orderRepositry){
        this.orderRepositry = orderRepositry ;
        compoundOrder = new CancelCompoundOrder(orderRepositry) ;
    }
    @GetMapping(value = "/CancelCompound/{code}")
    public String CancelOrder(@PathVariable("code") String code) {
        List<Order> order = orderRepositry.getComp(code);
        if (orderRepositry.checkCompoundOrder(order)){
            compoundOrder.RemoveOrder(order);
            return "Order canceled successfully" ;
        }
        else {
           return "we cant cancel your order , the order in his way to you ";
        }
    }
}
