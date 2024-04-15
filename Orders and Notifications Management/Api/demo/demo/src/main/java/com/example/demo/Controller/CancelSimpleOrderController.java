package com.example.demo.Controller;


import com.example.demo.Modules.Order;
import com.example.demo.Repo.OrderRepositry;
import com.example.demo.bsi.CancelSimpleOrder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CancelSimpleOrderController {
    private CancelSimpleOrder cancelSimpleOrder;
    private final OrderRepositry orderRepositry;
    public CancelSimpleOrderController(OrderRepositry orderRepositry){
        this.orderRepositry = orderRepositry;
        cancelSimpleOrder = new CancelSimpleOrder(orderRepositry);

    }
    @GetMapping(value = "/CancelSimple/{code}")
    public String CancelOrder(@PathVariable("code") String code) {
        Order order = orderRepositry.getSimple(code);
        if (orderRepositry.checkSimpleOrder(order)){
            cancelSimpleOrder.RemoveOrder(order);
            return "Order canceled successfully" ;
        }
        else {
            return "we cant cancel your order , the order in his way to you ";
        }
    }
}
