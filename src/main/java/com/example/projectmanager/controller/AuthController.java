package com.example.projectmanager.controller;

import com.example.projectmanager.dto.request.AuthRequestDto;
import com.example.projectmanager.dto.response.AuthResponseDto;
import com.example.projectmanager.service.impl.AuthServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@Validated
@RequestMapping("/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthServiceImpl authService;

    @PostMapping
    public AuthResponseDto auth(@Valid @RequestBody AuthRequestDto dto) {
        return authService.auth(dto);
    }
}
