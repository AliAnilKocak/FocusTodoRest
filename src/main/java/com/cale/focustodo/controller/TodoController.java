package com.cale.focustodo.controller;

import com.cale.focustodo.entity.Todo;
import com.cale.focustodo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class TodoController {

    @Autowired
    private TodoService todoService;


    @PostMapping("todos")
    @ResponseStatus(HttpStatus.CREATED)
    public Todo addTodo(@RequestBody Todo todo) {
        return todoService.saveTodo(todo);
    }

    @GetMapping("todos")
    public List<Todo> AllTodos() {
        return todoService.getTodos();
    }

    @GetMapping("todos/{id}")
    public Todo productById(@PathVariable int id) {
        return todoService.getTodoById(id);
    }

    @PutMapping("todos")
    public Todo updateTodo(@RequestBody Todo todo) {
        return todoService.updateTodo(todo);
    }

    @DeleteMapping("todos/{id}")
    public Todo deleteTodo(@PathVariable int id) {
        return todoService.deleteProduct(id);
    }

    @GetMapping("todos_p")
    @ResponseBody
    public List<Todo> findAllPaginated(@RequestParam("pageNumber") int pageNumber,
                                       @RequestParam("size") int size) {
        Page<Todo> resultPage = todoService.getPaginatedCharacters(pageNumber, size);
        return resultPage.getContent();
    }

}