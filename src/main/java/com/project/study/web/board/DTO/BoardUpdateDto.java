package com.project.study.web.board.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardUpdateDto {
    private Long BOAUID;
    private String TITLE;
    private String CONTENT;
    private String UPDATEDATE;
}
