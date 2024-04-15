package com.example.demo.Controller;


import com.example.demo.Modules.Customer;
import com.example.demo.Modules.Order;
import com.example.demo.Repo.CustomerRepositry;
import com.example.demo.Repo.OrderRepositry;
import com.example.demo.Repo.ProductRepositry;
import com.example.demo.Request.ObjectRequest;
import com.example.demo.bsi.CompoundOrder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class CompoundOrderController {
    private CompoundOrder compoundOrder ;
    private final ProductRepositry productRepositry ;
    private final CustomerRepositry customerRepositry ;
    private final OrderRepositry orderRepositry ;

    public CompoundOrderController(ProductRepositry productRepositry , CustomerRepositry customerRepositry , OrderRepositry orderRepositry) {
        this.productRepositry = productRepositry;
        this.customerRepositry = customerRepositry;
        this.orderRepositry = orderRepositry;
        compoundOrder = new CompoundOrder();
    }
    public void addtoDB(OrderRepositry orderRepositry,List<Order> order) {
        compoundOrder.makeOrder(orderRepositry,order);
    }
    @PostMapping(value = "/addSimpleOrder")
    public void add(@RequestBody ObjectRequest request){
        Customer customer =customerRepositry.getCustomer(request.getName());
        compoundOrder.add(customer, request.getList(),request.getAddress(),productRepositry.getProducts(),request.getQuantity());
    }
    @GetMapping (value = "/CompoundOrder")
    public String makeOrder(){
        addtoDB(orderRepositry , compoundOrder.getCompoundOrder());
        return compoundOrder.getCompoundOrder().get(0).getCode();
    }
}
