package com.example.demo.bsi;




import com.example.demo.Modules.Order;
import com.example.demo.Modules.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Queue;
@Service
public class EmailNotification implements channels {
    @Override
    public String sendSimple(Queue<Order> queue) {
        Order order = queue.peek();
        String template = "Email" + "\n" ;
        template += "your code : " + order.getCode()+"\n" ;
        template+= "Dear "+order.getCustomer().getName()+ ",\nyour booking of the items: " ;
        for (Product product : order.getProducts()){
            template += product.getName()+"\n";
        }
        template+= " is confirmed. thanks for using our store ";
        return template ;
    }
    @Override
    public String sendComp(Queue<List<Order>> queue) {
        String template = "";
        List<Order> list = queue.peek();
        template += "your code : " + list.get(0).getCode()+"\n" ;
        template += "Email" + "\n";
        for (Order order :list){
            template += "Dear "+order.getCustomer().getName()+ ",\nyour booking of the items: " ;
            for (Product product : order.getProducts()){
                template += product.getName()+"\n";
            }
            template+= " is confirmed. thanks for using our store "+ "\n";
        }
        return template ;
    }

}
