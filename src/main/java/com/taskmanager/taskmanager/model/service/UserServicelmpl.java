package com.taskmanager.taskmanager.model.service;

import java.util.Collections;

import com.taskmanager.taskmanager.model.UserRole;
import com.taskmanager.taskmanager.model.dto.CreateUserDTO;
import com.taskmanager.taskmanager.model.dto.UserDTO;
import com.taskmanager.taskmanager.model.enity.User;
import com.taskmanager.taskmanager.model.repo.UserRepository;
import com.taskmanager.taskmanager.model.service.UserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServicelmpl implements UserService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserServicelmpl(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User does not exist");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Collections.singletonList(new SimpleGrantedAuthority(user.getRole().name())));
    }

    @Override
    public UserDTO createUser(CreateUserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setRole(userDTO.getUsername().equals("Admin") ? UserRole.ADMIN : UserRole.MEMBER);
        user = repository.save(user);
        return convert(user);
    }

    private UserDTO convert(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setRole(user.getRole());
        return dto;
    }
}
