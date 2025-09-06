package com.afaaq.afaaqdash.dto;

import com.afaaq.afaaqdash.entities.StatisticAttribute;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class StatisticResponseDTO {
    private int id;
    private Date yearEdition;
    private int compaignId;
    private String compaignTitle;
    private List<StatisticAttribute> attributes;
}
