package com.example.demo.Repo;

import com.example.demo.Modules.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductRepositry {
    private Map<String, List<Product>> products ;

    public ProductRepositry(){
        products = new HashMap<>();
    }
    public double getPrice(String name){
        for (Map.Entry<String , List<Product>>entry:products.entrySet()){
            for (Product product : entry.getValue()){
                if (product.getName().equals(name)){
                    return product.getPrice();
                }
            }
        }
        return 0.0;
    }

    public Map<String,List<Product>> getProducts() {
        return products;
    }

    public String AddProduct(Product p){
        if (products.size()==0 || products.get(p.getCategory()) ==null){
            List<Product>list = new ArrayList<>();
            products.put(p.getCategory(),list);
            products.get(p.getCategory()).add(p);
        }
        else {
            for (Product product : products.get(p.getCategory())){
                if (p.getName().equals(product.getName())){
                    product.setQuantity(product.getQuantity()+p.getQuantity());
                    return "Added Successfully" ;
                }
            }
            products.get(p.getCategory()).add(p);
        }
        return "Added Successfully" ;
    }
    public Product getProduct(String Category,String id) {
        for (Product product : products.get(Category)){
            if (product.getSerialNumber().equals(id)){
                return product;
            }
        }
        return null;
    }
    public Product get(String name) {
        for (Map.Entry<String , List<Product>>entry:products.entrySet()){
            for (Product product : entry.getValue()){
                if (product.getName().equals(name)){
                    return product;
                }
            }
        }
        return null;
    }
    public void display(Map<Integer , Product>order){
        int counter = 1 ;
        for (Map.Entry<String , List<Product>>entry:products.entrySet()){
            System.out.println(entry.getKey() + " :");
            for (int x= 0 ; x < entry.getValue().size();x++){
                if (entry.getValue().get(x).getQuantity() == 0){
                    counter++;
                    continue;
                }
                System.out.println(counter + " " + entry.getValue().get(x).getName()+ ", Price : " + entry.getValue().get(x).getPrice() + ", Quantity : " +entry.getValue().get(x).getQuantity());
                order.put(counter , entry.getValue().get(x));
                counter++;
            }
            System.out.println();
        }
    }
    public Map<Integer,Product> getList(){
        int counter = 1;
        Map<Integer , Product> order = new HashMap<>() ;
        for (Map.Entry<String , List<Product>>entry:products.entrySet()){
            for (int x= 0 ; x < entry.getValue().size();x++){
                if (entry.getValue().get(x).getQuantity() == 0){
                    counter++;
                    continue;
                }
                order.put(counter , entry.getValue().get(x));
                counter++;
            }
        }
        return order;
    }
}
