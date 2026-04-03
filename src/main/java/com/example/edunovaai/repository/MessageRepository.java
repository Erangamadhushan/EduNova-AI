package com.example.edunovaai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.edunovaai.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {}