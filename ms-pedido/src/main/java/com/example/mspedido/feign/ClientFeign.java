package com.example.mspedido.feign;

import com.example.mspedido.dto.ClientDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-cliente-service", path = "/cliente")
public interface ClientFeign {
    @GetMapping("/{id}")
    @CircuitBreaker(name = "clientListByIdCB", fallbackMethod = "clientListById")

    public ResponseEntity<ClientDto> getById(@PathVariable Integer id);

    default ResponseEntity<ClientDto> clientListById(Integer id, Exception e) {
        return ResponseEntity.ok(new ClientDto());
    }
}
