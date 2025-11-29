package com.example.GenMuAI.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.GenMuAI.Entity.Chat;
import com.example.GenMuAI.Service.ChatService;

@RestController
public class ChatController {
    
    @Autowired
    private ChatService chatService;

    @PostMapping("/chats")
    public Chat saveChat(@RequestBody Map<String, String> request) {
        String userInput = request.get("userInput");
        return chatService.processChat(userInput);
    }

    @GetMapping("/chats")
    public List<Chat> fetchChatList() {
        return chatService.fetchChatList();
    }

    @GetMapping("/chats/{id}")
    public Chat fetchChatById(@PathVariable("id") Long id) {
        return chatService.fetchChatById(id);
    }

    @DeleteMapping("/chats/{id}")
    public String deleteChatById(@PathVariable("id") Long id){
        chatService.deleteChatById(id);
        return "User Deleted Successfully";
    }

    @PutMapping("/chats/{id}")
    public Chat updateChat(@PathVariable("id") Long id,
                                       @RequestBody Chat chat){
        return chatService.updateChat(id, chat);
    }

}
