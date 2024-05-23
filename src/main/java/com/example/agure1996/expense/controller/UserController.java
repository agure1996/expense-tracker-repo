package com.example.agure1996.expense.controller;

import com.example.agure1996.expense.model.User;
import com.example.agure1996.expense.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * Post - Create new User
     *
     * @param user
     * @return
     */
    @PostMapping("/newUser")
    public User newUser(@RequestBody User user) {
        return userService.newUser(user);
    }

    /**
     * GET all existing Users
     *
     * @return
     */
    @GetMapping("/getAllUsers")
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * GET - User by ID
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    /**
     * Update - User details
     *
     * @param id
     * @param userDetails
     * @return
     */
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        return userService.updateUser(id, userDetails);
    }

    /**
     * Delete - User by id
     *
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable long id) {
        userService.deleteUser(id);

    }

    /**
     * DELETE - All Users
     */
    @DeleteMapping("/deleteAllUsers")
    public void deleteAllUsers() {
        userService.deleteAllUser();
    }


}
