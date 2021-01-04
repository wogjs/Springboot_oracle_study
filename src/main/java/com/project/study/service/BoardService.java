package com.project.study.service;

import java.util.List;

import com.project.study.domain.BoardRepository;
import com.project.study.web.board.DTO.BoardDto;
import com.project.study.web.board.DTO.BoardWriteDto;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public List<BoardDto> board() {
        return boardRepository.board();
    }

    public Long write(BoardWriteDto writeDto) {
        return boardRepository.write(writeDto);
    }

    public Long test() {
        return boardRepository.test();
    }
}
