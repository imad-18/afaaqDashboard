package com.afaaq.afaaqdash.controllers;

import com.afaaq.afaaqdash.dto.StatisticResponseDTO;
import com.afaaq.afaaqdash.entities.Statistic;
import com.afaaq.afaaqdash.services.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public Statistic addStatistic(@RequestBody Statistic statDto) {
        return statisticService.saveStatistic(statDto);
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
                    dto.setCompaignId(stat.getCompaign() != null ? stat.getCompaign().getId() : 0);
                    dto.setCompaignTitle(stat.getCompaign() != null ? stat.getCompaign().getTitle() : null);
                    dto.setActivityId(stat.getActivity() != null ? stat.getActivity().getId() : 0);
                    dto.setActivityTitle(stat.getActivity() != null ? stat.getActivity().getTitle() : null);
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
