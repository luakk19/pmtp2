package ar.edu.unnoba.mp2026.courses.service;

import ar.edu.unnoba.mp2026.courses.model.Instructor;

public interface AuthenticationService {

    public String authenticate(Instructor instructor) throws Exception;
}
