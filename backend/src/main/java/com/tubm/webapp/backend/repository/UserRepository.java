package com.tubm.webapp.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tubm.webapp.backend.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
