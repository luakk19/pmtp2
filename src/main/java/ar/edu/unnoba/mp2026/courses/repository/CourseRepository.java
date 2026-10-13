package ar.edu.unnoba.mp2026.courses.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unnoba.mp2026.courses.model.Course;
import ar.edu.unnoba.mp2026.courses.model.CourseStatus;
import ar.edu.unnoba.mp2026.courses.model.Specialty;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByEstado(CourseStatus estado);

    List<Course> findByEspecialidad(Specialty especialidad);

    List<Course> findByInstructorId(Long instructorId);
}
