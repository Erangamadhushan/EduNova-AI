package com.example.edunovaai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.edunovaai.model.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
