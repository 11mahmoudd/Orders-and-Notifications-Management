package com.example.demo.Controller;

import com.example.demo.Modules.Product;
import com.example.demo.bsi.Catalog;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CatalogController {

    private Catalog catalog;

    public CatalogController(Catalog catalog){
        this.catalog = catalog ;
    }
    @PostMapping(value = "/catalog")
    public String add(@RequestBody Product p){
        return catalog.add(p);
    }
    @GetMapping(value = "/catalog/{category}/{id}")
    public Product getProduct(@PathVariable("category") String category , @PathVariable("id") String id){
        return catalog.getProduct(category,id);
    }
    @GetMapping(value = "/catalog/products")
    public Map<String,List<Product>> get(){
        return catalog.get();
    }

}
