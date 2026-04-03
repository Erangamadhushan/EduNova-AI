package com.example.edunovaai.model;

import lombok.Getter;
import lombok.Setter;
import lombok.Data;
import jakarta.persistence.*;


@Entity
@Data
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 5000)
    private String content;

    @Column(length = 3000)
    private String summary;

}
