package com.afaaq.afaaqdash.repository;

import com.afaaq.afaaqdash.entities.Compaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface CompaignRepo extends JpaRepository<Compaign, Integer> {

}
