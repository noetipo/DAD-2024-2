package com.example.mspedido.entity;

import com.example.mspedido.dto.ProductDto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double price;
    private Double amount;
    private Integer ProductId;
    @Transient
    private ProductDto productDto;
    public OrderDetail() {
        this.price = (double) 0;
        this.amount = (double) 0;
    }
}
