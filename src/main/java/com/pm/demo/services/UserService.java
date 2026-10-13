package com.pm.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pm.demo.entities.User;
import com.pm.demo.repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> listarUsuarios() {
        return userRepository.findAll();
    }

    public User buscarUsuario(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User guardarUsuario(User user) {
        return userRepository.save(user);
    }

    public void eliminarUsuario(Long id) {
        userRepository.deleteById(id);
    }
}