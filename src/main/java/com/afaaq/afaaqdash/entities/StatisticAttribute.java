package com.afaaq.afaaqdash.entities;

import jakarta.persistence.*;

@Entity
public class StatisticAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String attributeName;
    private String attributeValue; // store numbers as string, or use separate numeric/text column

    @ManyToOne
    @JoinColumn(name = "statistic_id")
    private Statistic statistic;
}