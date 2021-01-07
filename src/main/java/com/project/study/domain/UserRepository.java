package com.project.study.domain;

import com.project.study.session.UserInfo;
import com.project.study.web.user.DTO.SigninDto;
import com.project.study.web.user.DTO.SignupDto;
import com.project.study.web.user.DTO.UserDto;
import com.project.study.web.user.DTO.UserUpdateDto;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
    Long signup(SignupDto signupDto);

    UserDto signin(SigninDto signinDto);

    String authChe(UserInfo userInfo);

    Long update(UserUpdateDto updateDto);
}
