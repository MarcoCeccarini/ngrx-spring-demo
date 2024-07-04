package com.springboot.demo.crud;

import java.util.List;
import java.util.Optional;

public interface GenericService<T extends BaseEntity> {
    List<T> findAll();
    Optional<T> findById(Long id);
    T save(T entity);
    void deleteById(Long id);
}
