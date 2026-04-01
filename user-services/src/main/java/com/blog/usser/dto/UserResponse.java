package com.blog.usser.dto;

import lombok.Data;
import java.util.Set;

@Data
@SuppressWarnings("unused")
public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private Set<String> roles;
}