package com.afaaq.afaaqdash.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Statistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date YearEdition;
    private int Benificiers;
    private int volunteer;
    private long collects;
    private int PanniersDestribuer;

    @ManyToOne
    @JoinColumn(name = "compaign_id", nullable = false)
    private Compaign compaign;
}
