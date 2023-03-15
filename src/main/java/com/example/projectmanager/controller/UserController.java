package com.example.projectmanager.controller;

import com.example.projectmanager.dto.request.UserRequestDto;
import com.example.projectmanager.entity.User;
import com.example.projectmanager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/{id}")
    public User findUserById(@PathVariable Long id) {

        return userService.findUserById(id);
    }

    @PreAuthorize("hasAuthority('simple_user')")
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, UserRequestDto dto) {

        return userService.updateUser(id, dto);
    }

    @PreAuthorize("hasAuthority('admin')")
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {

        userService.deleteUserById(id);
    }
}
