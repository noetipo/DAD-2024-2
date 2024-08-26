package com.example.msclienteservice.service;

import com.example.msclienteservice.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<Cliente> list();

    Optional<Cliente> findById(Integer id);

    Cliente save(Cliente cliente);

    Cliente update(Cliente cliente);

    void delete(Integer id);
}
