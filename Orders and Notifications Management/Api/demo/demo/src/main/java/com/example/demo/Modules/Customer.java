package com.example.demo.Modules;

import org.springframework.stereotype.Component;

public class Customer {
    private String name ;
    private String email;
    private String PhoneNumber ;
    private double balance ;
    private String username;
    private String password;

    public Customer(String name, String email, double balance, String password, String username , String PhoneNumber) {
        this.name = name;
        this.email = email;
        this.balance = balance;
        this.password = password;
        this.username = username;
        this.PhoneNumber = PhoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getBalance() {
        return balance;
    }

    public String getPassword() {
        return password;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
