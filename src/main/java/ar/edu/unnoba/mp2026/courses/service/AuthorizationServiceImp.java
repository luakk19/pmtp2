package ar.edu.unnoba.mp2026.courses.service;

import org.springframework.stereotype.Service;

import ar.edu.unnoba.mp2026.courses.model.Instructor;
import ar.edu.unnoba.mp2026.courses.util.JwtTokenUtil;

@Service
public class AuthorizationServiceImp implements AuthorizationService {

    private final InstructorService instructorService;
    private final JwtTokenUtil jwtTokenUtil;

    public AuthorizationServiceImp(InstructorService instructorService, JwtTokenUtil jwtTokenUtil) {
        this.instructorService = instructorService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    public Instructor authorize(String token) throws Exception {
        // Verificar validez del token
        if (!jwtTokenUtil.verify(token)) {
            throw new Exception("Token JWT inválido");
        }

        // Recuperar el subject (email) del token
        String email = jwtTokenUtil.getSubject(token);

        // Buscar instructor por email
        Instructor instructor = instructorService.findByEmail(email);
        if (instructor == null) {
            throw new Exception("No existe un instructor con el email: " + email);
        }

        return instructor;
    }
}
