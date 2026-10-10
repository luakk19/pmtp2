package com.pm.demo.entities;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;

@Entity
public class User {
    @Id
    private long id;
    private String nombre;
    private String apellido;
}
