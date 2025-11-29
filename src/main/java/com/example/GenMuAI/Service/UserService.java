package com.example.GenMuAI.Service;

import java.util.List;

import com.example.GenMuAI.Entity.User;
import com.example.GenMuAI.Exception.UserNotFoundException;

public interface UserService {
    public User saveUser(User user);

    public List<User> fetchUserList();

    public User fetchUserById(String userId) throws UserNotFoundException;

    public void deleteUserById(String userId);

    public User updateUser(String userId, User user);

    public User fetchUserByName(String userName);
}
