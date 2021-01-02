package com.project.study.web.board.DTO;

import java.util.Date;

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
    private Date CREATEDATE;
    private Date UPDATEDATE;
}
