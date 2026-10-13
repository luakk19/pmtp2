package ar.edu.unnoba.mp2026.courses.model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "instructors")
public class Instructor extends User {

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Specialty> specialties;

    public Instructor() {
    }

    public List<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(List<Specialty> specialties) {
        this.specialties = specialties;
    }
}
