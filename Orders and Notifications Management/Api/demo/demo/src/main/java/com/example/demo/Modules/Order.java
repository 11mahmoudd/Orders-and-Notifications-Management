package com.example.demo.Modules;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Order {
    private String code ;
    private double price ;
    private List<Product> products;
    private Date date ;
    private Customer customer;
    private String address ;

    public Order(double price, Date date, Customer customer, String address, List <Product> products, String code) {
        this.price = price;
        this.date = date;
        this.customer = customer;
        this.address = address;
        this.products = products ;
        this.code = code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getAddress() {
        return address;
    }
}
