package com.example.user;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    public User updateUser(String id, User user){
        User existingUser = userRepo.findById(id).orElseThrow(()->
                new RuntimeException("User not found"));


        if (user.getUsername() != null && !user.getUsername().isBlank()) {
            existingUser.setUsername(user.getUsername());
        }
        if (user.getFirstname() != null && !user.getFirstname().isBlank()) {
            existingUser.setFirstname(user.getFirstname());
        }
        if (user.getLastname() != null && !user.getLastname().isBlank()) {
            existingUser.setLastname(user.getLastname());
        }
        if (user.getBio() != null && !user.getBio().isBlank()) {
            existingUser.setBio(user.getBio());
        }
        if (user.getBirthDate() != null && !user.getBirthDate().isBlank()) {
            existingUser.setBirthDate(user.getBirthDate());
        }
        if (user.getBalance() != null) {
            existingUser.setBalance(user.getBalance());
        }
        if (user.getEmail() != null && !user.getEmail().isBlank()) {
            existingUser.setEmail(user.getEmail());
        }

        // Always update the timestamp
        existingUser.setUpdatedAt(LocalDateTime.now());

        return userRepo.save(existingUser);

    }



}