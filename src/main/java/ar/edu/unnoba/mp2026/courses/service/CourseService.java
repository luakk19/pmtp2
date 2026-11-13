package ar.edu.unnoba.mp2026.courses.service;

import java.util.List;

import ar.edu.unnoba.mp2026.courses.model.Course;

public interface CourseService {

    public List<Course> getCoursesByInstructorId(Long instructorId);
}
