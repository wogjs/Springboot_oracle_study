package com.project.study.web.user;



import java.text.SimpleDateFormat;
import java.util.Date;

import com.project.study.domain.UserRepository;
import com.project.study.service.UserService;
import com.project.study.web.user.DTO.SigninDto;
import com.project.study.web.user.DTO.SignupDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserApiControllerTest {
    
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    Date now = new Date();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String nowDate = format.format(now);

    @Test
    public void signUP() {
        SignupDto upDto = new SignupDto();
        upDto.setID("TEST");
        upDto.setPW("TEST");
        upDto.setNAME("TEST");
        upDto.setEMAIL("TEST@email.com");
        upDto.setPHONE("01000000000");
        upDto.setCREATEDATE(nowDate);

        userRepository.signup(upDto);
    }

    @Test
    public void singIn() {
        SigninDto inDto = new SigninDto();
        inDto.setID("TEST");
        inDto.setPW("TEST");

        userService.signin(inDto);
    }
}
