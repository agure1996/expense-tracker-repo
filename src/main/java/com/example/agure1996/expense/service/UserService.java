package com.example.agure1996.expense.service;

import com.example.agure1996.expense.model.User;
import com.example.agure1996.expense.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
;

import java.util.Optional;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    /**
     * Create a new User
     */
    public User newUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Get all Users
     */
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }


    /**
     * Get User by Id
     */
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    /**
     * Update User
     */

    public User updateUser(Long id, User userDetails) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User existingUser = user.get();
            existingUser.setName(userDetails.getName());
            existingUser.setCategory(userDetails.getCategory());
            existingUser.setEmail(userDetails.getEmail());
            return userRepository.save(existingUser);
        }
        return null;
    }

    /**
     * Delete All User
     */

    public void deleteAllUser() {

        userRepository.deleteAll();
    }

    /**
     * Delete User
     */
    public void deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) userRepository.deleteById(id);
    }


}
