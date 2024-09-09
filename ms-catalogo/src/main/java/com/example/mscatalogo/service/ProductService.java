package com.example.mscatalogo.service;

import com.example.mscatalogo.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> list();

    Optional<Product> findById(Integer id);

    Product save(Product product);

    Product update(Product product);

    void delete(Integer id);
}
