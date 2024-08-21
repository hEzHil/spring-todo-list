package com.OpenSource.demo.ToDoList;

import java.util.List;
import java.util.Optional;

public interface ToDoDao {
    List<ToDoList> selectAllTaskList();
    Optional<ToDoList> selectTaskById(Long id);

    ToDoList saveTodo(ToDoList toDoList);
    void deleteById(Long id);

}
