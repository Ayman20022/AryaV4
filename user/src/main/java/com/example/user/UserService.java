package com.example.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public User getUserById(String id){
        return userRepo.findById(id).orElse(null);
    }

    public User createUser(User user){
        return userRepo.save(user);
    }

    public void deleteUser(String id){
        userRepo.deleteById(id);
    }



}