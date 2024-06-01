package com.sesar.betodo.services;

import com.sesar.betodo.models.Todo;
import com.sesar.betodo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public Todo createNewTodo(Todo todo) {
        todo.setCreatedAt(LocalDateTime.now());
        todo.setUpdatedAt(LocalDateTime.now());
        return todoRepository.save(todo);
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Optional<Todo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

    public Todo updateTodo(Long id, Todo todo) {
        Optional<Todo> existingTodoOptional = todoRepository.findById(id);
        if (existingTodoOptional.isPresent()) {
            Todo existingTodo = existingTodoOptional.get();
            todo.setCreatedAt(existingTodo.getCreatedAt());
            todo.setUpdatedAt(LocalDateTime.now());
            todo.setId(id);
            return todoRepository.save(todo);
        } else {
            throw new RuntimeException("Todo not found");
        }
    }
}
