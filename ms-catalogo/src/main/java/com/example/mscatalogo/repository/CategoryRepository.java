package com.example.mscatalogo.repository;

import com.example.mscatalogo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findByCode(String code);
}
