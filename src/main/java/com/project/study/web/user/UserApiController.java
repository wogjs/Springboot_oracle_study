package com.project.study.web.user;

import com.project.study.config.ApiResponse;
import com.project.study.service.UserService;
import com.project.study.session.UserInfo;
import com.project.study.web.user.DTO.SigninDto;
import com.project.study.web.user.DTO.SignupDto;
import com.project.study.web.user.DTO.UserDto;
import com.project.study.web.user.DTO.UserUpdateDto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Api(value = "회원", description = "회원 관리", tags = { "회원" })
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin("*")
@RestController
public class UserApiController {
    private final UserService userService;
    private final UserInfo userInfo;
    
    @ApiOperation(value = "회원가입")
    @PostMapping("/signup")
    public ResponseEntity<?> signup (@RequestBody SignupDto requestDto) {
        ApiResponse result = null;

        try {
            result = new ApiResponse(true, "성공", userService.signup(requestDto));
            userInfo.setUserID(requestDto.getID());
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ApiResponse(false, e.getMessage(), null);
            return ResponseEntity.badRequest().body(result);
        }
    }

    @ApiOperation(value = "로그인")
    @PostMapping("/signin")
    public ResponseEntity<?> signin (@RequestBody SigninDto requestDto) {
        ApiResponse result = null;

        try {
            UserDto user = userService.signin(requestDto);
            result = new ApiResponse(true, "성공", user);
            userInfo.setUserID(user.getID());
            userInfo.setAUTHS(user.getAUTHS());
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ApiResponse(false, e.getMessage(), null);
            return ResponseEntity.badRequest().body(result);
        }
    }

    @ApiOperation(value = "정보수정")
    @PutMapping("/{id}")
    public ResponseEntity<?> userUpdate(@RequestBody UserUpdateDto updateDto) {
        ApiResponse result = null;

        try {
            updateDto.setID(userInfo.getUserID());
            result = new ApiResponse(true, "성공", userService.update(updateDto));
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ApiResponse(false, e.getMessage(), null);
            return ResponseEntity.badRequest().body(result);
        }
    }
}
