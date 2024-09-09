package vn.hoidanit.jobhunter.controller;

import org.springframework.web.bind.annotation.RestController;

import vn.hoidanit.jobhunter.domain.User;
import vn.hoidanit.jobhunter.service.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // @GetMapping("/user/create")
    @PostMapping("/user")
    public User createNewUser(@RequestBody User user) {

        User userCreate = this.userService.handleCreateUser(user);
        return userCreate;
    }

    @DeleteMapping("/user/{user_id}")
    public String deleteUser(@PathVariable("user_id") long id) {
        this.userService.handleDeleteUser(id);
        return "Delete user with id: " + id;
    }

    @GetMapping("/user/{user_id}")
    public User getUser(@PathVariable("user_id") long id) {
        User user = this.userService.handleGetUser(id);
        return user;
    }

    @GetMapping("/user")
    public List<User> getAllUser() {
        return this.userService.handleGetAllUser();
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody User user) {
        return this.userService.handleUpdateUser(user);
    }
}
