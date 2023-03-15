package com.example.projectmanager.service;

import com.example.projectmanager.dto.request.UserRequestDto;
import com.example.projectmanager.entity.User;
import com.example.projectmanager.security.Authentication;
import java.util.List;

public interface UserService {

    User createUser(User user);

    List<User> findAllUsers();

    User findUserById(Long id);

    User updateUser(Long id, UserRequestDto dto);

    void deleteUserById(Long id);

}
