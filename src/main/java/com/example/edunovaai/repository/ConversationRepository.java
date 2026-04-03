package com.example.edunovaai.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.edunovaai.model.Conversation;

public interface ConversationRepository extends JpaRepository<Conversation, Long> {}
