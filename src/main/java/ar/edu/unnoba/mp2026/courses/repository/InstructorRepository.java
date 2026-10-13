package ar.edu.unnoba.mp2026.courses.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unnoba.mp2026.courses.model.Instructor;
import ar.edu.unnoba.mp2026.courses.model.Specialty;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {

    List<Instructor> findBySpecialtiesContaining(Specialty specialty);
}
