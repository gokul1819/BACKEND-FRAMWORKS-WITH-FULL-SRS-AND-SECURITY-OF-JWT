package com.examly.springapp.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.examly.springapp.model.User;
import com.examly.springapp.repository.UserRepo;

@Component
public class DataLoader implements CommandLineRunner {
    
    @Autowired
    private UserRepo userRepo;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public void run(String... args) throws Exception {
        if (userRepo.count() == 0) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setEmail("admin@example.com");
            admin.setRole("ADMIN");
            admin.setPassword(passwordEncoder.encode("admin123"));
            userRepo.save(admin);
            
            User user = new User();
            user.setUsername("user");
            user.setEmail("user@example.com");
            user.setRole("USER");
            user.setPassword(passwordEncoder.encode("user123"));
            userRepo.save(user);
            
            System.out.println("✓ Sample data loaded successfully!");
            System.out.println("Admin: admin/admin123");
            System.out.println("User: user/user123");
        }
    }
}