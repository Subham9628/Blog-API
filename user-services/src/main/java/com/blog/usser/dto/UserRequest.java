package com.blog.usser.dto;

import lombok.Data;
import java.util.Set;

@Data
@SuppressWarnings("unused")
public class UserRequest {
   
	private String name;
    private String email;
    private String password;
    private Set<String> roles; // role names
}
