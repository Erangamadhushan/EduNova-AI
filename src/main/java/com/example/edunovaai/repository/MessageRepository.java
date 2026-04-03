package com.example.edunovaai.repository;


import com.example.edunovaai.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {}
