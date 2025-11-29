package com.example.GenMuAI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.GenMuAI.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    
    public User findByUserName(String userName);
}
