package com.example.demo.bsi;
;

import com.example.demo.Modules.Order;
import com.example.demo.Modules.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Queue;
@Service
public class Shipping {
    public Shipping(){

    }
    public String Receipt(Order order){
            String msg = "";

            msg += "hey " + order.getCustomer().getUsername() +"\n";
            msg += "that is Receipt :" + "\n";
            msg+= "Name" +"          " + "price" +"          "+ "quantity"+"\n" ;
            for (Product product : order.getProducts()){
                msg+= product.getName() +"          " +product.getPrice()+"          " +product.getQuantity() +"\n";
            }
            msg+="\n";
            msg+= "your address : " + order.getAddress() +"\n";
            msg+= "your order will ship in :" + order.getDate()+3+"\n";
            msg+="Shipping fees : " + 0.26*order.getPrice() + "\n";
            msg+="\n";
            msg+="Total: " + (order.getPrice() + (0.26* order.getPrice())) +"\n";
           return msg;
        }

    public String SimpleShipping(Queue<Order>queue){
        Order order = queue.poll();
        return Receipt(order);
    }
    public String CompShipping(Queue<List<Order>>queues){
        String msg = "" ;
        List<Order> list = queues.poll();
        for (Order order : list) {
            msg += Receipt(order);
        }
        return msg;
    }
}
