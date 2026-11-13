package ar.edu.unnoba.mp2026.courses.service;

import ar.edu.unnoba.mp2026.courses.model.Instructor;

public interface InstructorService {

    public void create(Instructor instructor) throws Exception;

    public Instructor findByEmail(String email);
}
