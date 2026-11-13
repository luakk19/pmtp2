package ar.edu.unnoba.mp2026.courses.dto;

public class InstructorCoursesResponseDTO {

    private Long id;
    private String name;
    private String description;

    public InstructorCoursesResponseDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
