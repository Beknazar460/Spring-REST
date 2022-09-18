package com.springrest.Main.controller;

import com.springrest.Main.entity.UserEntity;
import com.springrest.Main.exception.UserAlreadyExistException;
import com.springrest.Main.exception.UserNotFoundException;
import com.springrest.Main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity createUsers(@RequestBody UserEntity user) {
        try {
            userService.createUser(user);
            return ResponseEntity.ok("Пользователь создан");
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(userService.getOneUser(id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.deleteUser(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

}
