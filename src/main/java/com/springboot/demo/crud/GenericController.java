package com.springboot.demo.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class GenericController<T extends BaseEntity> {

    protected final GenericService<T> service;

    @Autowired
    public GenericController(GenericService<T> service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<T> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public T create(@RequestBody T newEntity) {
        return service.save(newEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable Long id, @RequestBody T updatedEntity) {
        return service.findById(id)
                .map(existingEntity -> {
                    updatedEntity.setId(existingEntity.getId());
                    return ResponseEntity.ok(service.save(updatedEntity));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return service.findById(id)
                .map(existingEntity -> {
                    service.deleteById(id);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

