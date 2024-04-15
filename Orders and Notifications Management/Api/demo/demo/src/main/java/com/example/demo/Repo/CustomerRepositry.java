package com.example.demo.Repo;

import com.example.demo.Modules.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CustomerRepositry {
    private List<Customer> Customers ;

    public CustomerRepositry(){
        Customers  = new ArrayList<>();
    }
    public boolean AddCustomer(Customer p){
        for (Customer person : Customers ) {
            if (person.getUsername().equals(p.getUsername())) {
                System.out.println("this Username has been Taken !");
                return false;
            }
        }
        Customers.add(p);
        System.out.println("Added Successfully");
        return true ;
    }
    public Customer getCustomer(String username) {
        for (Customer person : Customers){
            if (person.getUsername().equals(username)){
                return person;
            }
        }
        return null;
    }
    public String remove(Customer customer) {
        Customers.remove(customer);
        return "Delete successfully" ;
    }
    public boolean checkCorrect(String email , String password){
        for (Customer i : Customers){
            if (i.getEmail().equals(email) && i.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}
