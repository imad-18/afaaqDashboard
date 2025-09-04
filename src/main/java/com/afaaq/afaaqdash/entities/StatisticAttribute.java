package com.afaaq.afaaqdash.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatisticAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String attributeName;
    private String attributeValue; // store numbers as string, or use separate numeric/text column

    @ManyToOne
    @JoinColumn(name = "statistic_id")
    @JsonBackReference
    private Statistic statistic;
}