package com.afaaq.afaaqdash.repository;

import com.afaaq.afaaqdash.entities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface ActivityRepo extends JpaRepository<Activity, Integer> {
}
