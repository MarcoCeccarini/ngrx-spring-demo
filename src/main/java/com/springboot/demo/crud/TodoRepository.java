package com.springboot.demo.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends GenericRepository<Todo>{
}

