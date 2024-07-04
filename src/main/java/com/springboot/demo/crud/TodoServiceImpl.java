package com.springboot.demo.crud;

import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl extends GenericServiceImpl<Todo>{

    public TodoServiceImpl(TodoRepository repository) {
        super(repository);
    }
}
