package com.example.demo.bsi;


import com.example.demo.Modules.Order;
import com.example.demo.Repo.OrderRepositry;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CancelCompoundOrder {
    private final OrderRepositry orderRepositry ;
    public CancelCompoundOrder(OrderRepositry orderRepositry){
    this.orderRepositry = orderRepositry;
    }
    public void RemoveOrder(List<Order>order) {
        orderRepositry.deleteCompound(order);
    }
}
