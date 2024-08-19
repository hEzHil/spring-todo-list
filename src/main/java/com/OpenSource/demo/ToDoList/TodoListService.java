package com.OpenSource.demo.ToDoList;

import com.sun.jdi.request.DuplicateRequestException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TodoListService {

    private final DaoLayer daoLayer;

    public TodoListService(DaoLayer daoLayer) {
        this.daoLayer = daoLayer;
    }

    public List<ToDoList> getAllCustomer(){
        return daoLayer.selectAllToDoList();
    }

    public void insertTask(ToDoRegistration toDoRegistration){
        String task = toDoRegistration.toDo();
        if(daoLayer.existsWithSameTask(task)){
            throw new DuplicateRequestException("The task is already here.");
        }
        // Ensure the date format is valid before proceeding

        ToDoList newTask = new ToDoList(task, toDoRegistration.date());
        if (newTask.getDate() != null) {
            daoLayer.insertTask(newTask);
        } else {
            throw new IllegalArgumentException("Invalid date format provided.");
        }
    }
}
