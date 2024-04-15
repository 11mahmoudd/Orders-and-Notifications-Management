package com.example.demo.Controller;

import com.example.demo.Modules.Customer;
import com.example.demo.bsi.Register;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    private Register register ;
    CustomerController(Register register) {
        this.register = register;
    }
    @PostMapping(value = "/signup")
    public String SignUp(@RequestBody Customer person){
        boolean check = register.add(person);
        if (check){
            return "Added Successfully" ;
        }
        else {
            return "this username is not available";
        }
    }
    @GetMapping(value = "/persons/{id}")
    public Customer getPerson(@PathVariable("id") String username){
        return register.get(username);
    }
    @GetMapping(value = "/Login/{username}/{password}")
    public Customer Login(@PathVariable("username") String username , @PathVariable("password") String password){
        return register.get(username);
    }
    @GetMapping(value = "/remove/{id}")
    public String remove(@PathVariable("id") String username){
        return register.remove(username);
    }


}
