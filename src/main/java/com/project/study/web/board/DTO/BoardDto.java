package com.project.study.web.board.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
    private Long BOAUID;
    private String USERID;
    private String TITLE;
    private String CONTENT;
    private String CREATEDATE;
    private String UPDATEDATE;
}
