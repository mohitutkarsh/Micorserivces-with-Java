package com.example.GenMuAI.Service;

import java.util.List;

import com.example.GenMuAI.Entity.Chat;

public interface ChatService {

    Chat processChat(String userInput);
    
    public Chat saveChat(Chat chat);

    public List<Chat> fetchChatList();

    public Chat fetchChatById(Long id);

    public void deleteChatById(Long id);

    public Chat updateChat(Long id, Chat chat);
}
