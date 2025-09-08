package com.afaaq.afaaqdash.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
/*public class Statistics {
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
}*/
public class Statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date yearEdition;

    @ManyToOne
    @JoinColumn(name = "compaign_id", nullable = true)  // allow null
    @JsonBackReference("compaign-statistics")
    private Compaign compaign;

    // Link to Activity
    @ManyToOne
    @JoinColumn(name = "activity_id")  // allow null
    @JsonBackReference("activity-statistics")
    private Activity activity;

    @OneToMany(mappedBy = "statistic", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<StatisticAttribute> attributes = new ArrayList<>();
}



