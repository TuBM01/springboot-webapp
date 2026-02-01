package com.tubm.webapp.backend.service;

import org.springframework.stereotype.Service;

@Service
public class JWTService {

    public String generateToken(String username) {
        return "token";
    }
}
