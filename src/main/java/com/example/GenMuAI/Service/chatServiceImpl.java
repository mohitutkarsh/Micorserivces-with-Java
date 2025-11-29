package com.example.GenMuAI.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.GenMuAI.Entity.Chat;
import com.example.GenMuAI.Repository.ChatRepository;

@Service
public class chatServiceImpl implements ChatService {
    
    @Autowired
    private ChatRepository chatRepository;

    private final String OPENAI_API_KEY = "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";
    private final String OPENAI_CHAT_COMPLETION_URL = "https://api.openai.com/v1/chat/completions";

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public Chat processChat(String userInput) {
        String aiResponse = getChatCompletion(userInput);

        Chat chat = new Chat();
        chat.setUserInput(userInput);
        chat.setAiResponse(aiResponse);
        chat.setModelUsed("gpt-4");
        chat.setTimestamp(LocalDateTime.now());

        return saveChat(chat);
    }

    private String getChatCompletion(String userInput) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", OPENAI_API_KEY);

        Map<String, Object> requestBody = Map.of(
            "model", "gpt-5",
            "messages", new Object[] {Map.of("role", "user", "content", userInput)}
        );

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(OPENAI_CHAT_COMPLETION_URL, request, Map.class);

        Map<String, Object> responseBody = response.getBody();
        if (responseBody != null) {
            var choices = (List<Map<String, Object>>) responseBody.get("choices");
            var message = (Map<String, Object>) choices.get(0).get("message");
            return message.get("content").toString();
        }
        return "No response";
    }

    @Override
    public Chat saveChat(Chat chat) {
        return chatRepository.save(chat);
    }

    @Override
    public List<Chat> fetchChatList() {
        return chatRepository.findAll();
    }

    @Override
    public Chat fetchChatById(Long id){
        Optional<Chat> chat =  chatRepository.findById(id);
        return chat.get();
    }

    @Override
    public void deleteChatById(Long id) {
        chatRepository.deleteById(id);
    }

    @Override
    public Chat updateChat(Long id, Chat chat) {
        Chat chatDB = chatRepository.findById(id).get();

        if(Objects.nonNull(chat.getId())) {
                    chatDB.setId(chat.getId());
        }

        return chatRepository.save(chatDB);
    }
    
}
