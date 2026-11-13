package ar.edu.unnoba.mp2026.courses.resource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unnoba.mp2026.courses.dto.CreateInstructorRequestDTO;
import ar.edu.unnoba.mp2026.courses.dto.InstructorAuthenticationRequestDTO;
import ar.edu.unnoba.mp2026.courses.dto.InstructorCoursesResponseDTO;
import ar.edu.unnoba.mp2026.courses.model.Course;
import ar.edu.unnoba.mp2026.courses.model.Instructor;
import ar.edu.unnoba.mp2026.courses.service.AuthenticationService;
import ar.edu.unnoba.mp2026.courses.service.AuthorizationService;
import ar.edu.unnoba.mp2026.courses.service.CourseService;
import ar.edu.unnoba.mp2026.courses.service.InstructorService;

@RestController
@RequestMapping("/instructor")
public class InstructorResource {

    private final InstructorService instructorService;
    private final AuthenticationService authenticationService;
    private final AuthorizationService authorizationService;
    private final CourseService courseService;
    private final ModelMapper modelMapper;

    public InstructorResource(InstructorService instructorService,
            AuthenticationService authenticationService,
            AuthorizationService authorizationService,
            CourseService courseService,
            ModelMapper modelMapper) {
        this.instructorService = instructorService;
        this.authenticationService = authenticationService;
        this.authorizationService = authorizationService;
        this.courseService = courseService;
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

    @PostMapping(value = "/auth", produces = "application/json")
    public ResponseEntity<?> authentication(@RequestBody InstructorAuthenticationRequestDTO dto) {
        try {
            Instructor instructor = modelMapper.map(dto, Instructor.class);
            String token = authenticationService.authenticate(instructor);
            return ResponseEntity.ok(Collections.singletonMap("token", token));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getCourses(@RequestHeader("Authorization") String token) {
        try {
            Instructor instructor = authorizationService.authorize(token);

            List<Course> courses = courseService.getCoursesByInstructorId(instructor.getId());

            List<InstructorCoursesResponseDTO> response = courses.stream()
                    .map(course -> modelMapper.map(course, InstructorCoursesResponseDTO.class))
                    .collect(Collectors.toList());

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }
}
