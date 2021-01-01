package com.project.study.domain;

import com.project.study.web.user.DTO.SigninDto;
import com.project.study.web.user.DTO.SignupDto;
import com.project.study.web.user.DTO.UserDto;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
    Long signup(SignupDto signupDto);

    UserDto signin(SigninDto signinDto);
}
