package com.sesar.betodo.controllers;

import com.sesar.betodo.exceptions.TodoNotFoundException;
import com.sesar.betodo.models.Todo;
import com.sesar.betodo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos() {
        return ResponseEntity.ok(todoService.getAllTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        Todo todo = todoService.getTodoById(id)
                .orElseThrow(() -> new TodoNotFoundException("Todo with ID " + id + " not found"));
        return ResponseEntity.ok(todo);
    }

    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(todoService.createNewTodo(todo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
        if (todoService.getTodoById(id).isEmpty()) {
            throw new TodoNotFoundException("Todo with ID " + id + " not found");
        }
        todo.setId(id);
        todoService.updateTodo(id, todo);
        Map<String, String> response = new HashMap<>();
        response.put("message", "TODO updated successfully");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteTodo(@PathVariable Long id) {
        if (todoService.getTodoById(id).isEmpty()) {
            throw new TodoNotFoundException("Todo with ID " + id + " not found");
        }
        todoService.deleteTodo(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "TODO deleted successfully");
        return ResponseEntity.ok(response);
    }

    @ExceptionHandler(TodoNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleTodoNotFoundException(TodoNotFoundException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleException(Exception e) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Internal Server Error: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
