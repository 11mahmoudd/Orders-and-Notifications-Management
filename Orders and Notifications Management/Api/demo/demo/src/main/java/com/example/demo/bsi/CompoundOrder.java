package com.example.demo.bsi;


import com.example.demo.Modules.Customer;
import com.example.demo.Modules.Order;
import com.example.demo.Modules.Product;
import com.example.demo.Repo.OrderRepositry;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

@Service
public class CompoundOrder {

private final List<Order>compoundOrder ;

    public List<Order> getCompoundOrder() {
        return compoundOrder;
    }

    public CompoundOrder() {

        compoundOrder = new ArrayList<>();
}

public void add(Customer customer , List<String> mp , String address , Map<String , List<Product>> mp2, List<Integer>quantity){
    SimpleOrder simpleOrder = new SimpleOrder();
    compoundOrder.add(simpleOrder.MakeOrder(customer , mp , address , mp2,quantity));
}
public void makeOrder(OrderRepositry orderRepositry , List<Order> orders){
    orderRepositry.addCompound(orders);
}
}
