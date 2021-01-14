package com.project.study.web.user;

import com.project.study.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@CrossOrigin("*")
@Controller
public class UserController {
    
    private final UserService userService;

    @ApiOperation(value = "로그인 화면")
    @GetMapping("/users/login")
    public String login (Model model) {
        return "user/login";
    }

    @ApiOperation(value = "회원가입 화면")
    @GetMapping("/users/signup")
    public String signup (Model model) {
        return "user/signup";
    }
}
