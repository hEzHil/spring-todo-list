package com.OpenSource.demo.ToDoList;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoListService  {

    private final ToDoDao toDoDao;



    public TodoListService(ToDoDao toDoDao) {
        this.toDoDao = toDoDao;

    }

    public List<ToDoList> getAllTask() {
        return toDoDao.selectAllTaskList();
    }

    public Optional<ToDoList> getTaskById(Long id) {
        return toDoDao.selectTaskById(id);
    }

    public ToDoList saveToDo(ToDoList toDoList) {
        if (toDoList.getTitle() == null || toDoList.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }
        return toDoDao.saveTodo(toDoList);
    }

    public void deleteById(Long id) {
        toDoDao.deleteById(id);
    }
}
