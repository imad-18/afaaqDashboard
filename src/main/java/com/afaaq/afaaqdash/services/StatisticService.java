package com.afaaq.afaaqdash.services;

import com.afaaq.afaaqdash.entities.Statistic;
import com.afaaq.afaaqdash.repositories.StatisticRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticService {
    @Autowired
    private StatisticRepo StatisticRepo;

    // create new statistic
    public Statistic saveStatistic(Statistic statistic) {
        return StatisticRepo.save(statistic);
    }

    // get all statistics
    public List<Statistic> getAllStatistics() {
        return StatisticRepo.findAll();
    }

    // delete statistic by id
    public void deleteStatisticById(int statID) {
        StatisticRepo.deleteById(statID);
    }
}
