package ar.edu.unnoba.mp2026.courses.service;

import ar.edu.unnoba.mp2026.courses.model.Instructor;

public interface AuthorizationService {

    public Instructor authorize(String token) throws Exception;
}
