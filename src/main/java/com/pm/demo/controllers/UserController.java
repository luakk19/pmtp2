package com.pm.demo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pm.demo.entities.User;
import com.pm.demo.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> listarUsuarios() {
        return userService.listarUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> buscarUsuario(@PathVariable Long id) {
        User user = userService.buscarUsuario(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public User guardarUsuario(@RequestBody User user) {
        return userService.guardarUsuario(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> actualizarUsuario(@PathVariable Long id, @RequestBody User user) {
        User existente = userService.buscarUsuario(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        user.setId(id);
        return ResponseEntity.ok(userService.guardarUsuario(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        User existente = userService.buscarUsuario(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        userService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
