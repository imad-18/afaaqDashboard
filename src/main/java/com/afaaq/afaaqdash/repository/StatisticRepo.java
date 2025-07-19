package com.afaaq.afaaqdash.repository;

import com.afaaq.afaaqdash.entities.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface StatisticRepo extends JpaRepository<Statistics, Integer> {
}
