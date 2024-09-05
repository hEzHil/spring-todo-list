package com.OpenSource.demo.ToDoList;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("jpa")
public class TaskAccessLayer implements ToDoDao{
    private final ToDoRepository toDoRepository;

    public TaskAccessLayer(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @Override
    public List<ToDoList> selectAllTaskList() {
        return toDoRepository.findAll();
    }

    @Override
    public Optional<ToDoList> selectTaskById(Long id) {
        return toDoRepository.findById(id);
    }

    @Override
    public ToDoList saveTodo(ToDoList toDoList) {
        return toDoRepository.save(toDoList);
    }

    @Override
    public void deleteById(Long id) {
        toDoRepository.deleteById(id);
    }
}
