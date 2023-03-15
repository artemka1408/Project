package com.example.projectmanager.service.impl;

import com.example.projectmanager.dto.request.AuthRequestDto;
import com.example.projectmanager.dto.response.AuthResponseDto;
import com.example.projectmanager.entity.Token;
import com.example.projectmanager.entity.User;
import com.example.projectmanager.exception.UserLoginNotFoundException;
import com.example.projectmanager.exception.UserPasswordNotMatchesException;
import com.example.projectmanager.repository.TokenRepository;
import com.example.projectmanager.repository.UserRepository;
import com.example.projectmanager.security.JwtTokenProvider;
import com.example.projectmanager.security.TokenGenerator;
import com.example.projectmanager.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    //private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenGenerator tokenGenerator;

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthResponseDto auth(AuthRequestDto requestDto) {
        final User user = userRepository.findUserByLogin(requestDto.getLogin())
                .orElseThrow(() -> new UserLoginNotFoundException("Пользователя с таким логином не существует"));
        if (!passwordEncoder.matches(requestDto.getPassword(), user.getPassword())) {
            throw new UserPasswordNotMatchesException("Пароли не совпадают");
        }

        //authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getLogin(), user.getPassword()));
        String token = jwtTokenProvider.createToken(user.getLogin(), user.getRole().name());
        //final String token = tokenGenerator.generate();

        final Token tokenEntity = Token.builder()
                .token(token)
                .user(user)
                .build();

        tokenRepository.save(tokenEntity);

        return new AuthResponseDto(token);
    }
}
