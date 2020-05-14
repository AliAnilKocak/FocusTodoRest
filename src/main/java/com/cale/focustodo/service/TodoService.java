package com.cale.focustodo.service;


import com.cale.focustodo.dto.TodoDto;
import com.cale.focustodo.entity.ApplicationUser;
import com.cale.focustodo.entity.Todo;
import com.cale.focustodo.repository.TodoRepository;
import com.cale.focustodo.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {


    private TodoRepository todoRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public TodoService(TodoRepository todoRepository, ModelMapper modelMapper, UserRepository userRepository) {
        this.todoRepository = todoRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    public TodoDto saveTodo(TodoDto todoDto) {
        Todo todoEntity = modelMapper.map(todoDto, Todo.class);
        ApplicationUser applicationUser = userRepository.getOne(todoDto.getUser_id());
        todoEntity.setUser(applicationUser);

        todoEntity = todoRepository.save(todoEntity);
        todoDto.setId(todoEntity.getId());
        return todoDto;
    }

    public TodoService todoRepository(final TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
        return this;
    }

    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    public Page<Todo> getPaginatedCharacters(int pageNumber, int size) {
        PageRequest pageable = PageRequest.of(pageNumber - 1, size);
        Page<Todo> resultPage = todoRepository.findAll(pageable);
        if (pageNumber > resultPage.getTotalPages()) {
            throw new IllegalStateException("Not Found Page Number:" + pageNumber);
        }
        return resultPage;
    }

    public Todo getTodoById(int todoId) {
        return todoRepository.findById(todoId).orElse(null);
    }

    public List<Todo> getTodoByIdDetail(int actionId) {
        return todoRepository.getByAction_Id(actionId);
    }

    public Todo deleteProduct(int todoId) {
        Todo todo = getTodoById(todoId);
        todoRepository.deleteById(todoId);
        return todo;
    }

    public Todo updateTodo(Todo todo) {
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
