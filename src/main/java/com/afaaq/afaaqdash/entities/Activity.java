package com.afaaq.afaaqdash.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String iconPath;
    private String title;

    @Column(length = 1000)
    private String description;

    @ElementCollection
    private List<String> goals;

    @Column(length = 1000)
    private String feedback;

    private String location;

    private String duration;

    private LocalDate launchDate;

    private Integer effective;

    @ElementCollection
    private List<String> albums;

    private String category;
}

