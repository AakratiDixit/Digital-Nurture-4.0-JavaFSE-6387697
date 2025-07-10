package com.example.jwt_auth_service.controller;

import com.example.jwt_auth_service.util.JwtUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(Principal principal) {
    System.out.println("Inside /authenticate for user: " + principal.getName());

    String token = JwtUtil.generateToken(principal.getName());
    Map<String, String> response = new HashMap<>();
    response.put("token", token);
    return response;
}

}
