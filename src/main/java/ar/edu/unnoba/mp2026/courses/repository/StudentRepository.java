package ar.edu.unnoba.mp2026.courses.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unnoba.mp2026.courses.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByDni(String dni);
}
