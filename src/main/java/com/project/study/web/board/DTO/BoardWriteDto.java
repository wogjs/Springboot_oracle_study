package com.project.study.web.board.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardWriteDto {
    private Long BOAUID;
    private String USERID;
    private String TITLE;
    private String CONTENT;
    private String CREATEDATE;
}
