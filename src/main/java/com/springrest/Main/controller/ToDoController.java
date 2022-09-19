package com.springrest.Main.controller;

import com.springrest.Main.entity.ToDoEntity;
import com.springrest.Main.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class ToDoController {

    @Autowired
    ToDoService toDoService;

    @PostMapping
    public ResponseEntity createToDo(@RequestBody ToDoEntity toDo,
                                     @RequestParam Long userId) {
        try {
            return ResponseEntity.ok(toDoService.createToDo(toDo, userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

    @PutMapping
    public ResponseEntity UpdateToDo(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(toDoService.updateToDo(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }
}
