package com.taskmanager.taskmanager.model.service;

import com.taskmanager.taskmanager.model.dto.CreateUserDTO;
import com.taskmanager.taskmanager.model.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDTO createUser(CreateUserDTO userDTO);
}
