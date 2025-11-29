package com.example.GenMuAI.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GenMuAI.Entity.User;
import com.example.GenMuAI.Exception.UserNotFoundException;
import com.example.GenMuAI.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> fetchUserList() {
        return userRepository.findAll();
    }

    @Override
    public User fetchUserById(String userId) throws UserNotFoundException {
        Optional<User> user =  userRepository.findById(userId);

        if(!user.isPresent()){
            throw new UserNotFoundException("User not found");
        }

        return user.get();
    }

    @Override
    public void deleteUserById(String userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User updateUser(String userId, User user) {
        User userDB = userRepository.findById(userId).get();

        if(Objects.nonNull(user.getUserId()) &&
                !"".equalsIgnoreCase(user.getUserId())) {
                    userDB.setUserId(user.getUserId());
        }

        if(Objects.nonNull(user.getUserName()) &&
                !"".equalsIgnoreCase(user.getUserName())) {
                    userDB.setUserName(user.getUserName());
        }

        if(Objects.nonNull(user.getPassword()) &&
                !"".equalsIgnoreCase(user.getPassword())) {
                    userDB.setPassword(user.getPassword());
        }

        return userRepository.save(userDB);
    }

    @Override
    public User fetchUserByName(String userName) {
        return userRepository.findByUserName(userName);
    }
    
}
