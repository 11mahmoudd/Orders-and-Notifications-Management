package com.example.demo.bsi;
import com.example.demo.Modules.Product;
import com.example.demo.Repo.ProductRepositry;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class Catalog {
    private ProductRepositry productRepositry;
    Catalog(ProductRepositry productRepositry){
        this.productRepositry = productRepositry;
    }
    public String add(Product p){
        return productRepositry.AddProduct(p);
    }
    public Product getProduct(String category,String id){
        return productRepositry.getProduct(category,id);
    }
    public Map<String,List<Product>> get(){
        return productRepositry.getProducts();
    }
}
