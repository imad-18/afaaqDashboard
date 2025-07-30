package com.afaaq.afaaqdash.controllers;
import com.afaaq.afaaqdash.dto.LoginRequest;
import com.afaaq.afaaqdash.entities.Admin;
import com.afaaq.afaaqdash.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/save-admin")
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        admin.setPassword(adminService.encodePassword(admin.getPassword()));
        Admin savedAdmin = adminService.saveAdmin(admin);
        return ResponseEntity.ok(savedAdmin);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        boolean isAuthenticated = adminService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());

        if (isAuthenticated) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}

