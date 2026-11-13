package ar.edu.unnoba.mp2026.courses.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unnoba.mp2026.courses.model.Course;
import ar.edu.unnoba.mp2026.courses.repository.CourseRepository;

@Service
public class CourseServiceImp implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImp(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getCoursesByInstructorId(Long instructorId) {
        return courseRepository.findByInstructorId(instructorId);
    }
}
