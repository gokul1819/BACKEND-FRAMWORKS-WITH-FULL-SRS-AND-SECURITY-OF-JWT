package com.examly.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.User;
import com.examly.springapp.repository.UserRepo;
import com.examly.springapp.exception.ResourceNotFoundException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepo userRepo;
    
    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }
    
    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
    
    @Override
    public User getUserById(Long id) {
        return userRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }
    
    @Override
    public User updateUser(Long id, User user) {
        User existingUser = userRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        
        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        existingUser.setRole(user.getRole());
        return userRepo.save(existingUser);
    }
    
    @Override
    public List<User> getUsersByRole(String role) {
        return userRepo.findByRole(role);
    }
    
    @Override
    public List<User> getUsersByUsernameAndRole(String username, String role) {
        return userRepo.findByUsernameAndRole(username, role);
    }
}
