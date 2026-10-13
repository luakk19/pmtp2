package ar.edu.unnoba.mp2026.courses.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "approval_requests")
public class ApprovalRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaSolicitud;
    private LocalDate fechaResolucion;

    @Enumerated(EnumType.STRING)
    private ApprovalRequestStatus estado;

    private String comentarioInstructor;
    private String comentarioAdministrador;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public ApprovalRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDate fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public LocalDate getFechaResolucion() {
        return fechaResolucion;
    }

    public void setFechaResolucion(LocalDate fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    public ApprovalRequestStatus getEstado() {
        return estado;
    }

    public void setEstado(ApprovalRequestStatus estado) {
        this.estado = estado;
    }

    public String getComentarioInstructor() {
        return comentarioInstructor;
    }

    public void setComentarioInstructor(String comentarioInstructor) {
        this.comentarioInstructor = comentarioInstructor;
    }

    public String getComentarioAdministrador() {
        return comentarioAdministrador;
    }

    public void setComentarioAdministrador(String comentarioAdministrador) {
        this.comentarioAdministrador = comentarioAdministrador;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
