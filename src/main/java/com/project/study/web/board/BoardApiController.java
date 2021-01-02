package com.project.study.web.board;

import com.project.study.config.ApiResponse;
import com.project.study.service.BoardService;
import com.project.study.session.UserInfo;
import com.project.study.web.board.DTO.BoardWriteDto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Api(value = "게시판", description = "게시판 관리", tags = { "게시판" })
@RequestMapping("/board")
@RequiredArgsConstructor
@CrossOrigin("*")
@RestController
public class BoardApiController {
    private final BoardService boardService;
    private final UserInfo userInfo;

    @ApiOperation(value = "게시판 등록")
    @PostMapping("/write")
    public ResponseEntity<?> boardWrite (@RequestBody BoardWriteDto writeDto){
        ApiResponse result = null;
        // writeDto.setUESRID(userInfo.getUserID());
        try {
            result = new ApiResponse(true, "성공", boardService.write(writeDto));
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ApiResponse(false, e.getMessage(), null);
            return ResponseEntity.badRequest().body(result);
        }
    }

}
