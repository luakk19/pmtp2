package ar.edu.unnoba.mp2026.courses.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "administrators")
public class Administrator extends User {

    public Administrator() {
    }
}
