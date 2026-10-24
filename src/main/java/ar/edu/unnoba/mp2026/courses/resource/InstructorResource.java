package ar.edu.unnoba.mp2026.courses.resource;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unnoba.mp2026.courses.dto.CreateInstructorRequestDTO;
import ar.edu.unnoba.mp2026.courses.model.Instructor;
import ar.edu.unnoba.mp2026.courses.service.InstructorService;

@RestController
@RequestMapping("/instructor")
public class InstructorResource {

    private final InstructorService instructorService;
    private final ModelMapper modelMapper;

    public InstructorResource(InstructorService instructorService, ModelMapper modelMapper) {
        this.instructorService = instructorService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody CreateInstructorRequestDTO dto) {
        try {
            Instructor instructor = modelMapper.map(dto, Instructor.class);
            instructorService.create(instructor);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
}
