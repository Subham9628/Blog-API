package com.blog.auth.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.blog.auth.dto.RegisterRequest;
import com.blog.auth.entity.Role;
import com.blog.auth.entity.User;
import com.blog.auth.repository.RoleRepository;
import com.blog.auth.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String register(RegisterRequest request) {

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEnabled(true);

        Role role = roleRepository.findByRoleName("ROLE_USER").get();

        Set<Role> roles = new HashSet<>();
        roles.add(role);

        user.setRoles(roles);

        userRepository.save(user);

        return "User Registered Successfully";
    }
}