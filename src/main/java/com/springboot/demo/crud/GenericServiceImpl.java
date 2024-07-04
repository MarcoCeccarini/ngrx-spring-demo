package com.springboot.demo.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class GenericServiceImpl<T extends BaseEntity> implements GenericService<T> {

    private final GenericRepository<T> repository;

    @Autowired
    public GenericServiceImpl(GenericRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public List<T> findAll() {

        return repository.findAll();
    }

    @Override
    public Optional<T> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

