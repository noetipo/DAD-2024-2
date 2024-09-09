package com.example.mspedido.feign;

import com.example.mspedido.dto.ClientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-cliente-service", path = "/cliente")
public interface ClientFeign {
    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> getById(@PathVariable Integer id);
}
