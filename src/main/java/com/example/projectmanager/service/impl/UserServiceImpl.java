package com.example.projectmanager.service.impl;

import com.example.projectmanager.dto.request.UserRequestDto;
import com.example.projectmanager.entity.User;
import com.example.projectmanager.entity.enums.Role;
import com.example.projectmanager.exception.ForbiddenException;
import com.example.projectmanager.exception.UserLoginNotFoundException;
import com.example.projectmanager.exception.UserNotFoundException;
import com.example.projectmanager.exception.UserPasswordNotMatchesException;
import com.example.projectmanager.repository.UserRepository;
import com.example.projectmanager.security.Authentication;
import com.example.projectmanager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public User createUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(Long id) {

        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Пользователь с id " + id + " не найден!"));
    }

    public User updateUser(Long id, UserRequestDto dto) {

        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Пользователь не найден"));

        user.setLogin(dto.getLogin());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        return userRepository.save(user);
    }

    public void deleteUserById(Long id) {

        userRepository.deleteUserById(id).orElseThrow(() -> new UserNotFoundException("Пользователь таким id " + " не найден"));
    }

    public Authentication authenticateByLoginAndPassword(String login, String password) {

        User user = userRepository.findUserByLogin(login)
                .orElseThrow(() -> new UserLoginNotFoundException("Пользователь с login " + login + " не найден"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new UserPasswordNotMatchesException("Пароли не совпадают");
        }

        Authentication authentication = Authentication.builder()
                .id(user.getId())
                .role(user.getRole())
                .build();

        return authentication;
    }
}
