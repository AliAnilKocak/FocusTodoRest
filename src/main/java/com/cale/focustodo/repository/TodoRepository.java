package com.cale.focustodo.repository;

import com.cale.focustodo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Integer> {
    Page<Todo> findAll(Pageable pageable);
}
