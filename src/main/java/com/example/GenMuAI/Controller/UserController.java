package com.example.GenMuAI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.GenMuAI.Entity.User;
import com.example.GenMuAI.Exception.UserNotFoundException;
import com.example.GenMuAI.Service.UserService;

@RestController
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/users")
    public List<User> fetchUserList() {
        return userService.fetchUserList();
    }

    @GetMapping("/users/{id}")
    public User fetchUserById(@PathVariable("id") String userId) throws UserNotFoundException {
        return userService.fetchUserById(userId);
    }

    @DeleteMapping("/users/{id}")
    public String deleteUserById(@PathVariable("id") String userId){
        userService.deleteUserById(userId);
        return "User Deleted Successfully";
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable("id") String UserId,
                                       @RequestBody User User){
        return userService.updateUser(UserId, User);
    }

    @GetMapping("/users/name/{name}")
    public User fetchUserByName(@PathVariable("name") String userName){
        return userService.fetchUserByName(userName);
    }

}