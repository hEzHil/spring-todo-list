package com.OpenSource.demo.ToDoList;

import java.util.List;

public interface DaoLayer {
    List<ToDoList> selectAllToDoList();
    boolean existsWithSameTask(String toDo);
    void insertTask(ToDoList toDoList);
}
