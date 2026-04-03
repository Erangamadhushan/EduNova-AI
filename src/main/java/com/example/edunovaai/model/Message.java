package com.example.edunovaai.model;

import jakarta.persistence.*;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role; // user / assistant

    @Column(length = 5000)
    private String content;

    @ManyToOne
    private Conversation conversation;
}