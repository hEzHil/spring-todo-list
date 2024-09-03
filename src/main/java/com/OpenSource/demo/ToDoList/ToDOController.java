package com.OpenSource.demo.ToDoList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/todo")
public class ToDOController {

    private final TodoListService toDoService;

    public ToDOController(TodoListService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping
    public List<ToDoList> getAllToDos() {
        return toDoService.getAllTask();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDoList> getToDoById(@PathVariable Long id) {
        Optional<ToDoList> toDo = toDoService.getTaskById(id);
        return toDo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ToDoList> createToDo(@RequestBody ToDoList toDo) {
        if (toDo.getTitle() == null || toDo.getTitle().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        ToDoList savedToDo = toDoService.saveToDo(toDo);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedToDo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToDoList> updateToDoTitle(@PathVariable Long id, @RequestBody ToDoList updatedToDo) {
        if (updatedToDo.getTitle() == null || updatedToDo.getTitle().trim().isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        Optional<ToDoList> optionalToDo = toDoService.getTaskById(id);

        if (optionalToDo.isPresent()) {
            ToDoList toDo = optionalToDo.get();
            toDo.setTitle(updatedToDo.getTitle());
            ToDoList updatedTodo = toDoService.saveToDo(toDo);
            return ResponseEntity.ok(updatedTodo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteToDoById(@PathVariable Long id) {
        toDoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}