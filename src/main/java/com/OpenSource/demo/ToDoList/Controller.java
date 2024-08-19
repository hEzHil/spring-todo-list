package com.OpenSource.demo.ToDoList;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/todo")
public class Controller {

     public final TodoListService todoListService;

    public Controller(TodoListService todoListService) {
        this.todoListService = todoListService;
    }
    @GetMapping
    public List<ToDoList> getAllCustomers(){
        return todoListService.getAllCustomer();
    }

    @PostMapping
    public void addTask(@RequestBody  ToDoRegistration toDoRegistration){
        todoListService.insertTask(toDoRegistration);
    }
}
