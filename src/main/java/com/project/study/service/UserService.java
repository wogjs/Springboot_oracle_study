package com.project.study.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.project.study.domain.UserRepository;
import com.project.study.web.user.DTO.SigninDto;
import com.project.study.web.user.DTO.SignupDto;
import com.project.study.web.user.DTO.UserDto;
import com.project.study.web.user.DTO.UserUpdateDto;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    Date now = new Date();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String nowDate = format.format(now);

    // 회원가입
    public Long signup(SignupDto dto) {
        dto.setCREATEDATE(nowDate);
        return userRepository.signup(dto);
    }

    // 로그인
    public UserDto signin(SigninDto dto) {
        return userRepository.signin(dto);
    }

    // 정보수정
    public Long update(UserUpdateDto updateDto) {
        updateDto.setUPDATEDATE(nowDate);
        return userRepository.update(updateDto);
    }
}
