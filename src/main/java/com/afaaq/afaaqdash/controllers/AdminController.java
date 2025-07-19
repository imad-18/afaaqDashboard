package com.afaaq.afaaqdash.controllers;

import com.afaaq.afaaqdash.entities.Admin;
import com.afaaq.afaaqdash.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    //create an admin
    @PostMapping("/saveAdmin")
    public Admin createAdmin(@RequestBody Admin admin) {
        System.out.println("Received admin: " + admin);
        return adminService.saveAdmin(admin);
    }

}
