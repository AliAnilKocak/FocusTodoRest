package com.cale.focustodo.service;


import com.cale.focustodo.entity.Todo;
import com.cale.focustodo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {


    @Autowired
    private TodoRepository todoRepository;

    public Todo saveTodo(Todo todo){
        return todoRepository.save(todo);
    }

    public List<Todo> getTodos(){
        return  todoRepository.findAll();
    }

    public Page<Todo> getPaginatedCharacters(int pageNumber,int size) {
        PageRequest pageable = PageRequest.of(pageNumber - 1, size);
        Page<Todo> resultPage = todoRepository.findAll(pageable);
        if (pageNumber > resultPage.getTotalPages()) {
            throw new IllegalStateException("Not Found Page Number:" + pageNumber);
        }
        return resultPage;
    }

    public Todo getTodoById(int todoId){
        return todoRepository.findById(todoId).orElse(null);
    }
    public List<Todo> getTodoByIdDetail(int actionId){
        return todoRepository.getByAction_Id(actionId);
    }

    public Todo deleteProduct(int todoId){
        Todo todo = getTodoById(todoId);
        todoRepository.deleteById(todoId);
        return todo;
    }

    public Todo updateTodo(Todo todo){
        System.out.println(todo.toString());
        Todo existingTodo = todoRepository.findById(todo.getId()).orElse(null);
        existingTodo.setTitle(todo.getTitle());
        existingTodo.setDescription(todo.getDescription());
        existingTodo.setIs_favorite(todo.getIs_favorite());
        existingTodo.setTime(todo.getTime());
        existingTodo.setEnergy(todo.getEnergy());
        existingTodo.setDueDate(todo.getDueDate());
        return todoRepository.save(existingTodo);
    }



}
