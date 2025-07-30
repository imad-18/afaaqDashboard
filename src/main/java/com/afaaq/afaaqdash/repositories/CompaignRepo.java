package com.afaaq.afaaqdash.repositories;

import com.afaaq.afaaqdash.entities.Compaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface CompaignRepo extends JpaRepository<Compaign, Integer> {
    List<Compaign> findByTitle(String title);
}
