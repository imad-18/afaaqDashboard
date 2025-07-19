package com.afaaq.afaaqdash.services;

import com.afaaq.afaaqdash.entities.Admin;
import com.afaaq.afaaqdash.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminRepo adminRepo;

    //save an Admin
    public Admin saveAdmin(Admin admin) {
        return adminRepo.save(admin);
    }
}
