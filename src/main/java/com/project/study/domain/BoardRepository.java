package com.project.study.domain;

import java.util.List;

import com.project.study.web.board.DTO.BoardDto;
import com.project.study.web.board.DTO.BoardUpdateDto;
import com.project.study.web.board.DTO.BoardWriteDto;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardRepository {
    
    List<BoardDto> board();

    List<BoardDto> boardTest();

    Long write(BoardWriteDto writeDto);

    Long update(BoardUpdateDto updateDto);

    Long delete(Long uid);
}
