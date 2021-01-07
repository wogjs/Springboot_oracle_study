package com.project.study.web.user;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.project.study.domain.UserRepository;
import com.project.study.web.user.DTO.SigninDto;
import com.project.study.web.user.DTO.SignupDto;
import com.project.study.web.user.DTO.UserDto;
import com.project.study.web.user.DTO.UserUpdateDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserApiControllerTest {
    
    @Autowired
    UserRepository userRepository;

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

        UserDto user = userRepository.signin(inDto);

        assertThat("TEST").isEqualTo(user.getID());
        assertThat("TEST").isEqualTo(user.getPW());
    }

    @Test
    public void updateUser() {
        UserUpdateDto updateDto = new UserUpdateDto();
        updateDto.setID("TEST");
        updateDto.setPW("UPDATE");
        updateDto.setEMAIL("UPDATE@email.com");
        updateDto.setPHONE("01011112222");
        updateDto.setUPDATEDATE(nowDate);

        userRepository.update(updateDto);
    }
}
