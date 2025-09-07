package com.afaaq.afaaqdash.dto;

import com.afaaq.afaaqdash.entities.StatisticAttribute;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class StatisticResponseDTO {
    private int id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date yearEdition;
    private int compaignId;
    private String compaignTitle;
    private List<StatisticAttribute> attributes;
}
