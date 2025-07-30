package com.afaaq.afaaqdash.services;

import com.afaaq.afaaqdash.entities.Admin;
import com.afaaq.afaaqdash.repositories.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Admin saveAdmin(Admin admin) {
        return adminRepo.save(admin);
    }

    public boolean authenticate(String email, String rawPassword) {
        Admin admin = adminRepo.findAdminsByEmail(email);
        return admin != null && passwordEncoder.matches(rawPassword, admin.getPassword());
    }

    public String encodePassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }
}
