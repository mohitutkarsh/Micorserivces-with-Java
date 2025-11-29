package com.example.GenMuAI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.GenMuAI.Entity.Chat;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
}

