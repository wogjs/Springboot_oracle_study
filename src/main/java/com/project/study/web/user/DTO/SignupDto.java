package com.project.study.web.user.DTO;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor  // 값 없는 파라미터 생성
@AllArgsConstructor // this.ID = ID 같은 build 생략 기능
public class SignupDto {
    private String ID;
    private String PW;
    private String NAME;
    private String EMAIL;
    private String PHONE;
    private LocalDateTime CREATEDATE;
}
