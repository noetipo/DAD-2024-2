package com.example.mscatalogo.service;

import com.example.mscatalogo.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> list();
    Optional<Category> findById(Integer id);
    Category save(Category category);
    Category update(Category category);
    void delete(Integer id);
}
