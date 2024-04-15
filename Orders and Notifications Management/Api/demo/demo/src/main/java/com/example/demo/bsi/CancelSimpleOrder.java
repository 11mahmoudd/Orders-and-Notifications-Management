package com.example.demo.bsi;


import com.example.demo.Modules.Order;
import com.example.demo.Repo.OrderRepositry;
import org.springframework.stereotype.Service;

@Service
public class CancelSimpleOrder {
    private final OrderRepositry orderRepositry;
    public CancelSimpleOrder(OrderRepositry orderRepositry) {
        this.orderRepositry =orderRepositry;
    }
    public void RemoveOrder(Order order) {
        orderRepositry.deleteSimple(order);
    }
}
