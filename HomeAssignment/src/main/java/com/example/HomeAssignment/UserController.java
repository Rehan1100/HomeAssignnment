package com.example.HomeAssignment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAllUser")
    public List<Object> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/getAllPosts")
    public List<Object> getAllPosts() {
        return userService.getAllThePost();
    }

    @GetMapping("/getAllComments")
    public List<Object> getAllTheComments() {
        return userService.getAllTheComments();
    }
}
