package com.project.study.web.user;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;

@Api(value = "회원", description = "회원 관리", tags = { "회원" })
@RequestMapping("/user")
@AllArgsConstructor
@CrossOrigin("*")
@RestController
public class UserApiController {
    
}
