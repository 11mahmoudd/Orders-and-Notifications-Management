package com.example.demo.bsi;


import com.example.demo.Modules.Customer;
import com.example.demo.Modules.Order;
import com.example.demo.Modules.Product;
import com.example.demo.Repo.OrderRepositry;
import com.example.demo.Repo.ProductRepositry;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.*;

@Service
public class SimpleOrder {
    private Order order ;
    public SimpleOrder(){
    }

    public Order MakeOrder(Customer customer , List<String> mp , String address , Map<String , List<Product>> mp2 , List<Integer> quantity){
        double price = 0.0;
        List<Product> list = new ArrayList<>();
        for (int x = 0 ; x < mp.size();x++){
            String name = mp.get(x);
            for (Map.Entry<String , List<Product>>entry2:mp2.entrySet()){
                for (Product product : entry2.getValue()){
                    if (product.getName().equals(name)){
                        price+= (product.getPrice() + quantity.get(x));
                        list.add(product);
                        break;
                    }
                }
            }
        }
        Date date = new Date();
        String code = Code(10);
        Order order1 = new Order(price,date,customer,address,list,code);
        return order1 ;
    }
    public void add(OrderRepositry orderRepositry,Order order){
        orderRepositry.addSimple(order);
    }
    private final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public String Code(int length) {
        StringBuilder randomString = new StringBuilder(length);
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            randomString.append(CHARACTERS.charAt(randomIndex));
        }
        return randomString.toString();
    }
    }

