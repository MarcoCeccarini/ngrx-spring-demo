package com.springboot.demo.crud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController extends GenericController<Todo> {
    public TodoController(GenericService<Todo> service) {
        super(service);
    }
}
