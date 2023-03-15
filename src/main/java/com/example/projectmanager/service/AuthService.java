package com.example.projectmanager.service;

import com.example.projectmanager.dto.request.AuthRequestDto;
import com.example.projectmanager.dto.response.AuthResponseDto;

public interface AuthService {

    AuthResponseDto auth(AuthRequestDto requestDto);
}
