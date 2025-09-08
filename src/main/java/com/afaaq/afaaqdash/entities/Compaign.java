package com.afaaq.afaaqdash.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Compaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @Column(length = 1000)
    private String description;

    @ElementCollection
    private List<String> imagesPath;

    @OneToMany(mappedBy = "compaign", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("compaign-statistics")
    private List<Statistic> statistics = new ArrayList<>();
}
