package com.cale.focustodo.controller;

import com.cale.focustodo.entity.Action;
import com.cale.focustodo.entity.Todo;
import com.cale.focustodo.service.ActionService;
import com.cale.focustodo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class ActionController {

    @Autowired
    private ActionService actionService;


    @PostMapping("actions")
    @ResponseStatus(HttpStatus.CREATED)
    public Action addAction(@RequestBody Action action) {
        return actionService.saveAction(action);
    }

    @GetMapping("actions")
    public List<Action> AllActions() {
        return actionService.getActions();
    }

    @GetMapping("actions/{id}")
    public Action productById(@PathVariable int id) {
        return actionService.getActionById(id);
    }



}
