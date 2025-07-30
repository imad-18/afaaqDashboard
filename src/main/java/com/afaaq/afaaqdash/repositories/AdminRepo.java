package com.afaaq.afaaqdash.repositories;

import com.afaaq.afaaqdash.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface AdminRepo extends JpaRepository<Admin, Integer> {
    Admin findAdminsByEmail(String email);
}
