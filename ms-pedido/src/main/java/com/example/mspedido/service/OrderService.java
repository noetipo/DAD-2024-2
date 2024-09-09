package com.example.mspedido.service;

import com.example.mspedido.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    public List<Order> list();

    public Order save(Order order);

    public Optional<Order> findById(Integer id);

    public void delete(Integer id);

    public Order update(Order order);
}
