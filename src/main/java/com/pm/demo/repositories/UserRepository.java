package com.pm.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pm.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
