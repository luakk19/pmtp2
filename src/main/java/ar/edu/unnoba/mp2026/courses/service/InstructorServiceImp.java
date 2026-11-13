package ar.edu.unnoba.mp2026.courses.service;

import org.springframework.stereotype.Service;

import ar.edu.unnoba.mp2026.courses.model.Instructor;
import ar.edu.unnoba.mp2026.courses.repository.InstructorRepository;
import ar.edu.unnoba.mp2026.courses.util.PasswordEncoder;

@Service
public class InstructorServiceImp implements InstructorService {

    private final InstructorRepository instructorRepository;
    private final PasswordEncoder passwordEncoder;

    public InstructorServiceImp(InstructorRepository instructorRepository, PasswordEncoder passwordEncoder) {
        this.instructorRepository = instructorRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void create(Instructor instructor) throws Exception {
        // Validar que no existe otro instructor con el mismo email
        Instructor existente = instructorRepository.findByEmail(instructor.getEmail());
        if (existente != null) {
            throw new Exception("Ya existe un instructor con el email: " + instructor.getEmail());
        }

        // Generar hash criptográfico para la contraseña
        String hashedPassword = passwordEncoder.encode(instructor.getPassword());
        instructor.setPassword(hashedPassword);

        // Guardar el instructor en la base de datos
        instructorRepository.save(instructor);
    }

    @Override
    public Instructor findByEmail(String email) {
        return instructorRepository.findByEmail(email);
    }
}
