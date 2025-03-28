package it.capstone.finalproject.auth;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
