package com.blog.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blog.auth.dto.LoginRequest;
import com.blog.auth.dto.RegisterRequest;
import com.blog.auth.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) 
    {
    	   
        return authService.register(request);
     
    }
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) 
    {
    	    return authService.login(request);
        
    }
}