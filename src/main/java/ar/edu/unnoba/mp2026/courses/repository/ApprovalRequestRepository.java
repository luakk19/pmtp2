package ar.edu.unnoba.mp2026.courses.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unnoba.mp2026.courses.model.ApprovalRequest;
import ar.edu.unnoba.mp2026.courses.model.ApprovalRequestStatus;

public interface ApprovalRequestRepository extends JpaRepository<ApprovalRequest, Long> {

    List<ApprovalRequest> findByCourseId(Long courseId);

    List<ApprovalRequest> findByEstado(ApprovalRequestStatus estado);
}
