package com.afaaq.afaaqdash.controllers;

import com.afaaq.afaaqdash.entities.Statistic;
import com.afaaq.afaaqdash.services.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statistics")
public class StatisticController {
    @Autowired
    private StatisticService statisticService;

    // create statistic api
    @PostMapping
    public Statistic addStatistic(@RequestBody Statistic statistic) {
        return statisticService.saveStatistic(statistic);
    }

    // get all statistics api
    @GetMapping
    public List<Statistic> getAllStatistics() {
        return statisticService.getAllStatistics();
    }


}
