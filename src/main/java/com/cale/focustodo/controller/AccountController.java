package com.cale.focustodo.controller;

import com.cale.focustodo.entity.ApplicationUser;
import com.cale.focustodo.entity.Login;
import com.cale.focustodo.service.JwtUtilService;
import com.cale.focustodo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtilService jwtUtil;
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Login> login(@RequestBody ApplicationUser userCredentials) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userCredentials.getUsername(), userCredentials.getPassword())
            );
        } catch (Exception e) {
            throw new Exception("Invalid Credentials");
        }
        return jwtUtil.generateToken(userCredentials.getUsername());
    }

    @PostMapping("/register")
    public String register(@RequestBody ApplicationUser user) {
        if (userService.registerUser(user)) {
            return "User Created";
        }
        return "User Creation Failed!";
    }
}
