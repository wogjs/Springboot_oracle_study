package com.project.study.service;

import com.project.study.domain.UserRepository;
import com.project.study.web.user.DTO.SigninDto;
import com.project.study.web.user.DTO.SignupDto;
import com.project.study.web.user.DTO.UserDto;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Long signup(SignupDto dto) {
        return userRepository.signup(dto);
    }

    public UserDto signin(SigninDto dto) {
        return userRepository.signin(dto);
    }
}
