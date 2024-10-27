package com.harini.Video.Conferencing.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void register(User user) {
        user.setStatus("online");
        userRepository.save(user);
    }

    public User login(User user) {
        // Find user by email in the MongoDB database
        User cUser = userRepository.findByEmail(user.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Check if the password matches
        if (!cUser.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("Password incorrect");
        }

        // Set status to "online"
        cUser.setStatus("online");

        // Update the user's status in the database
        userRepository.save(cUser);

        return cUser;
    }

    public void logout(String email) {
            // Find user by email in MongoDB
        User user = userRepository.findByEmail(email)
        .orElseThrow(() -> new RuntimeException("User not found"));

        // Set status to "offline"
        user.setStatus("offline");

        // Update the user's status in the database
        userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
