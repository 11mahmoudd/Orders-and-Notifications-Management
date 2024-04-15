package com.example.demo.Repo;



import com.example.demo.Modules.Customer;
import com.example.demo.Modules.Order;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
@Component
public class OrderRepositry {
    private Queue<Order>simpleOrder ;
    private Map<Customer , Integer> map;
    private Map<String , Integer>map2 ;

    private Queue<List<Order>>compoundOrder;
    public OrderRepositry() {
         simpleOrder = new LinkedList<>();
         compoundOrder = new LinkedList<>();
         map = new HashMap<>();
         map2= new HashMap<>();
    }
    public void addMap(Customer customer){
        if (map.size() > 0){
            if (map.get(customer) == null) {
                map.put(customer,1);
            }
            else{
                map.put(customer,map.get(customer)+1);
            }
        }
        else {
            map.put(customer,1);
        }
    }
    public void addMap2(String str){
        if (map.size() > 0) {
            if (map2.get(str) == null) {
                map2.put(str, 1);
            }
            else {
                map2.put(str,map.get(str)+1);
            }
        }
        else {
           map2.put(str,1);
        }
    }
    public Order getSimple(String code) {
        for (Order order : simpleOrder) {
            if (order.getCode().equals(code)){
                return order;
            }
        }
        return null;
    }

    public String getMostNotificationTemplate(){
        int Max = -1 ;
        String name = "" ;
        for (Map.Entry<String, Integer> entry : map2.entrySet()){
            if (entry.getValue() > Max) {
                Max = entry.getValue();
                name= entry.getKey();
            }
        }
        System.out.println(Max);
        return name;
    }
    public Customer getMostNotified(){
        int Max = -1 ;
        Customer customer = null ;
        for (Map.Entry<Customer, Integer> entry : map.entrySet()){
            if (entry.getValue() > Max) {
                Max = entry.getValue();
                customer = entry.getKey();
            }
        }
        return customer;
    }
    public List<Order> getComp(String Code){
        for (List<Order> list :compoundOrder){
            for (Order order :list) {
                if (order.getCode().equals(Code)){
                    return list;
                }
            }
        }
        return null;
    }
    public boolean checkSimpleOrder(Order order){
        for (Order order1 : simpleOrder) {
            if (order.equals(order1)){
                return true;
            }
        }
        return false;
    }
    public boolean checkCompoundOrder(List<Order> order){
        int counter = 0 ;
        for (List<Order> order1 : compoundOrder) {
            for (int x = 0 ; x < order1.size();x++){
                if (order.get(x).equals(order1.get(x))){
                    counter++;
                }
            }
        }
        if (counter == order.size()){
            return true;
        }
        return false;
    }
    public String addSimple(Order order) {
        simpleOrder.add(order);
        return "Added Successfully" ;
    }
    public String addCompound(List<Order> order) {
        compoundOrder.add(order);
        return "Added Successfully" ;
    }
    public String deleteSimple(Order order) {
        simpleOrder.remove(order);
        return "Deleted successfully" ;
    }
    public String deleteCompound(List<Order> order) {
        compoundOrder.remove(order);
        return "Deleted successfully" ;
    }
    public List<Order>getCompoundOrder(Customer customer, String code){
        for (List<Order>orders : compoundOrder){
            for (Order order : orders ){
                if (order.getCustomer().getUsername().equals(customer.getUsername())){
                    if (order.getCode().equals(code)){
                        return orders;
                    }
                }
            }
        }
        return null;
    }
    public Order getSimpleOrder(String code) {
        for (Order order : simpleOrder) {
            if (order.getCode().equals(code)){
                return order;
            }
        }
        return null;
    }
    public Queue<Order> getSimpleOrders(){
        return simpleOrder;
    }
    public Queue<List<Order>> getCompoundOrderOrders(){
        return compoundOrder;
    }
}
