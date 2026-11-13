package ar.edu.unnoba.mp2026.courses.service;

import org.springframework.stereotype.Service;

import ar.edu.unnoba.mp2026.courses.model.Instructor;
import ar.edu.unnoba.mp2026.courses.util.JwtTokenUtil;
import ar.edu.unnoba.mp2026.courses.util.PasswordEncoder;

@Service
public class AuthenticationServiceImp implements AuthenticationService {

    private final InstructorService instructorService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtTokenUtil;

    public AuthenticationServiceImp(InstructorService instructorService, PasswordEncoder passwordEncoder,
            JwtTokenUtil jwtTokenUtil) {
        this.instructorService = instructorService;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    public String authenticate(Instructor instructor) throws Exception {
        // Buscar instructor por email
        Instructor existente = instructorService.findByEmail(instructor.getEmail());
        if (existente == null) {
            throw new Exception("No existe un instructor con el email: " + instructor.getEmail());
        }

        // Verificar password
        if (!passwordEncoder.verify(instructor.getPassword(), existente.getPassword())) {
            throw new Exception("Credenciales inválidas");
        }

        // Generar y retornar token JWT
        return jwtTokenUtil.generateToken(existente.getEmail());
    }
}
