package com.project.study.web.board.DTO;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardWriteDto {
    private String USERID;
    private String TITLE;
    private String CONTENT;
    private LocalDateTime CREATEDATE;
}