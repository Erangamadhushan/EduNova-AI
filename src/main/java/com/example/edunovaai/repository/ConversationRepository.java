package com.example.edunovaai.repository;


import com.example.edunovaai.model.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversationRepository extends JpaRepository<Conversation, Long> {}
