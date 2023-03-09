package com.microfocus.HelloRest.service;

import com.microfocus.HelloRest.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    Product p1=new Product(1,"laptop","electronics",50000);
    Product p2=new Product(2,"headphone","electronics",5000);
    Product p3=new Product(3,"Jacket","Fashion",2000);

    List<Product> list= Arrays.asList(p1,p2,p3);
    ArrayList<Product> allProducts=new ArrayList<>(list);

    public List<Product> getAllProduct()
    {
        return allProducts;
    }
}
