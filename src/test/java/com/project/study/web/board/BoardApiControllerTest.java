package com.project.study.web.board;

import java.util.List;

import com.project.study.domain.BoardRepository;
import com.project.study.web.board.DTO.BoardDto;
import com.project.study.web.board.DTO.BoardUpdateDto;
import com.project.study.web.board.DTO.BoardWriteDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BoardApiControllerTest {
    
    @Autowired
    BoardRepository boardRepository;

    @Test
    public void createBoard(){
        BoardWriteDto writeDto = new BoardWriteDto();
        writeDto.setUSERID("TEST");
        writeDto.setTITLE("TEST");
        writeDto.setCONTENT("TEST content");
        writeDto.setCREATEDATE("2021-01-07");

        boardRepository.write(writeDto);
    }

    @Test
    public void boardCheck_Delete() {
        List<BoardDto> blist = boardRepository.boardTest();

        // 삽입 확인
        assertThat("TEST").isEqualTo(blist.get(0).getTITLE());

        // 게시글 삭제
        boardRepository.delete(blist.get(0).getBOAUID());
    }

    @Test
    public void boardUpdate_Delete() {
        List<BoardDto> blist = boardRepository.boardTest();
        BoardUpdateDto updateDto = new BoardUpdateDto();
        updateDto.setBOAUID(blist.get(0).getBOAUID());
        updateDto.setTITLE("UPDATE");
        updateDto.setCONTENT("UPDATE CONTENT");
        updateDto.setUPDATEDATE("2021-01-08");

        boardRepository.update(updateDto);

        // 업데이트 확인
        List<BoardDto> check = boardRepository.boardTest();
        assertThat("UPDATE").isEqualTo(check.get(0).getTITLE());

        // 게시글 삭제
        boardRepository.delete(check.get(0).getBOAUID());
    }
}
