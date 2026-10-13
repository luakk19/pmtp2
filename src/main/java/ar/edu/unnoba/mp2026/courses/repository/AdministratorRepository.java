package ar.edu.unnoba.mp2026.courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unnoba.mp2026.courses.model.Administrator;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
}
