package com.project.study.web.board;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.project.study.domain.BoardRepository;
import com.project.study.web.board.DTO.BoardWriteDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BoardApiControllerTest {
    
    @Autowired
    BoardRepository boardRepository;

    Date now = new Date();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String nowDate = format.format(now);

    @Test
    public void 게시판등록(){
        BoardWriteDto writeDto = new BoardWriteDto();
        
    }

}
