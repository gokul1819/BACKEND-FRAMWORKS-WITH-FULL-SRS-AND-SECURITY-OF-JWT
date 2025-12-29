package com.examly.springapp.service;

import com.examly.springapp.model.User;
import java.util.List;

public interface UserService {
    User createUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    User updateUser(Long id, User user);
    List<User> getUsersByRole(String role);
    List<User> getUsersByUsernameAndRole(String username, String role);
}
