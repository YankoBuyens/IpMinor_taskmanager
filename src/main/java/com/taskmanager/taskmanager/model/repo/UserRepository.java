package com.taskmanager.taskmanager.model.repo;

import com.taskmanager.taskmanager.model.enity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}