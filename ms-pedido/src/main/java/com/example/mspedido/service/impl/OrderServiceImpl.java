package com.example.mspedido.service.impl;

import com.example.mspedido.entity.Order;
import com.example.mspedido.feign.ClientFeign;
import com.example.mspedido.feign.ProductFeign;
import com.example.mspedido.repository.OrderRepository;
import com.example.mspedido.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductFeign productFeign;
    @Autowired
    private ClientFeign clientFeign;

    @Override
    public List<Order> list() {
        return orderRepository.findAll();
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Optional<Order> findById(Integer id) {
        Optional<Order> order = orderRepository.findById(id);
        order.get().setClientDto(clientFeign.getById(order.get().getClientId()).getBody());
        /*for (OrderDetail orderDetail : order.get().getOrderDetails()) {
            orderDetail.setProductDto(productFeign.getById(orderDetail.getProductId()).getBody());
        }*/
        /*order.get().getOrderDetails().stream().forEach(orderDetail -> {
            orderDetail.setProductDto(productFeign.getById(orderDetail.getProductId()).getBody());
        });*/
        order.get().getOrderDetails().forEach(orderDetail -> {
            orderDetail.setProductDto(productFeign.getById(orderDetail.getProductId()).getBody());
        });
        return order;
    }

    @Override
    public void delete(Integer id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order update(Order order) {
        return orderRepository.save(order);
    }
}
