package com.project.study.web.user.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String ID;
    private String PW;
    private String NAME;
    private String EMAIL;
    private String PHONE;
    private String AUTHS;
    private String CREATEDATE;
    private String UPDATEDATE;
}
