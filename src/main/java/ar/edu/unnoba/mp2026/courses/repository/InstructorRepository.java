package ar.edu.unnoba.mp2026.courses.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ar.edu.unnoba.mp2026.courses.model.Instructor;
import ar.edu.unnoba.mp2026.courses.model.Specialty;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {

    List<Instructor> findBySpecialtiesContaining(Specialty specialty);

    public Instructor findByEmail(@Param("email") String email);
}
