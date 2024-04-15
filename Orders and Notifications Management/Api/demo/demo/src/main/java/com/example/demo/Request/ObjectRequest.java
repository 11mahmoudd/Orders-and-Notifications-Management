package com.example.demo.Request;

import java.util.List;

public class ObjectRequest {

    private String name ;

    private String address ;
    private List<String> list;
    private List<Integer>quantity ;

    public List<Integer> getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public List<String>getList() {
        return list;
    }

    public String getAddress() {
        return address;
    }
}
