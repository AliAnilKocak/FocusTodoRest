package com.cale.focustodo.service;


import com.cale.focustodo.entity.Action;
import com.cale.focustodo.entity.Todo;
import com.cale.focustodo.repository.ActionRepository;
import com.cale.focustodo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionService {


    @Autowired
    private ActionRepository actionRepository;

    public Action saveAction(Action action){
        return actionRepository.save(action);
    }

    public List<Action> getActions(){
        return  actionRepository.findAll();
    }

    public Action getActionById(int actionId){
        return actionRepository.findById(actionId).orElse(null);
    }






}
