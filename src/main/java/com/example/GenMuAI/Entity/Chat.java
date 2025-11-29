package com.example.GenMuAI.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ChatCompletion")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userInput;
    private String aiResponse;
    private String modelUsed;
    private java.time.LocalDateTime timestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public String getAiResponse() {
        return aiResponse;
    }

    public void setAiResponse(String aiResponse) {
        this.aiResponse = aiResponse;
    }

    public String getModelUsed() {
        return modelUsed;
    }

    public void setModelUsed(String modelUsed) {
        this.modelUsed = modelUsed;
    }

    public java.time.LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(java.time.LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Chat() {
    }

    public Chat(String userInput, String aiResponse, String modelUsed, java.time.LocalDateTime timestamp) {
        this.userInput = userInput;
        this.aiResponse = aiResponse;
        this.modelUsed = modelUsed;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "ChatCompletion{" +
                "id=" + id +
                ", userInput='" + userInput + '\'' +
                ", aiResponse='" + aiResponse + '\'' +
                ", modelUsed='" + modelUsed + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}

