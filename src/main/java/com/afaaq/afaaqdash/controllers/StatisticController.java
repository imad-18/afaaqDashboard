package com.afaaq.afaaqdash.controllers;

import com.afaaq.afaaqdash.dto.StatisticResponseDTO;
import com.afaaq.afaaqdash.entities.Statistic;
import com.afaaq.afaaqdash.services.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public List<StatisticResponseDTO> getAllStatistics() {
        /*return statisticService.getAllStatistics();*/
        return statisticService.getAllStatistics().stream()
                .map(stat -> {
                    StatisticResponseDTO dto = new StatisticResponseDTO();
                    dto.setId(stat.getId());
                    dto.setYearEdition(stat.getYearEdition());
                    dto.setCompaignId(stat.getCompaign().getId());
                    dto.setCompaignTitle(stat.getCompaign().getTitle());
                    dto.setAttributes(stat.getAttributes());
                    return dto;
                })
                .toList();
    }

    // delete statistic by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteStatistic(@PathVariable int id) {
        statisticService.deleteStatisticById(id);
        return ResponseEntity.ok().body(Map.of("message", "statistic deleted successfully !"));
    }


}
