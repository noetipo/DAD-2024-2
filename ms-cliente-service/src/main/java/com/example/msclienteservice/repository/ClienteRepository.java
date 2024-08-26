package com.example.msclienteservice.repository;

import com.example.msclienteservice.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    List<Cliente> findByCode(String code);
}
