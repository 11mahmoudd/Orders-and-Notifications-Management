package com.example.demo.bsi;

import com.example.demo.Modules.Customer;
import com.example.demo.Repo.CustomerRepositry;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class Register {
    private CustomerRepositry repo ;
    public Register(CustomerRepositry repo){
        this.repo = repo;
    }
    Scanner input = new Scanner(System.in);
    public String remove(String username){
        return repo.remove(repo.getCustomer(username));
    }
    public boolean add(Customer p) {
        return repo.AddCustomer(p);
    }
    public Customer get(String username) {
        return repo.getCustomer(username);
    }
}
