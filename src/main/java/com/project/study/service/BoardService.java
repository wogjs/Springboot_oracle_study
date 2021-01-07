package com.project.study.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.project.study.domain.BoardRepository;
import com.project.study.web.board.DTO.BoardDto;
import com.project.study.web.board.DTO.BoardUpdateDto;
import com.project.study.web.board.DTO.BoardWriteDto;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    Date now = new Date();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String nowDate = format.format(now);


    public List<BoardDto> board() {
        return boardRepository.board();
    }

    public Long write(BoardWriteDto writeDto) {
        writeDto.setCREATEDATE(nowDate);
        return boardRepository.write(writeDto);
    }

    public Long update(BoardUpdateDto updateDto) {
        updateDto.setUPDATEDATE(nowDate);
        return boardRepository.update(updateDto);
    }

    public Long delete(Long boauid) {
        return boardRepository.delete(boauid);
    }
}
