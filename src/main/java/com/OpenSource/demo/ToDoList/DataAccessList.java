package com.OpenSource.demo.ToDoList;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class DataAccessList implements DaoLayer {

    private static  final List<ToDoList> toDoLists ;
    static {
        toDoLists = new ArrayList<>();
        ToDoList task1 = new ToDoList(
                1,
                "Study Java",
                "10-09-2020"
        );
        toDoLists.add(task1);

        ToDoList task2 = new ToDoList(
                2,
                "Go For Gym",
                "10-09-2020"
        );
        toDoLists.add(task2);


        ToDoList task3 = new ToDoList(
                3,
                "Work with springboot framework",
                "10-09-2020"
        );
        toDoLists.add(task3);
    }

    @Override
    public List<ToDoList> selectAllToDoList() {
        return toDoLists;
    }

    @Override
    public boolean existsWithSameTask(String toDo) {
        return toDoLists.stream()
                .anyMatch(c -> c.getToDo().equals(toDo));
    }

    @Override
    public void insertTask(ToDoList toDoList) {
        toDoLists.add(toDoList);
    }
}
