package com.project.study.web.board;

import com.project.study.config.ApiResponse;
import com.project.study.service.BoardService;
import com.project.study.session.UserInfo;
import com.project.study.web.board.DTO.BoardUpdateDto;
import com.project.study.web.board.DTO.BoardWriteDto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Api(value = "게시판", description = "게시판 관리", tags = { "게시판" })
@RequestMapping("/board")
@RequiredArgsConstructor
@CrossOrigin("*")
@RestController
public class BoardApiController {
    private final BoardService boardService;
    private final UserInfo userInfo;

    @ApiOperation(value = "게시글 등록")
    @PostMapping("/write")
    public ResponseEntity<?> boardWrite (@RequestBody BoardWriteDto writeDto){
        ApiResponse result = null;
        writeDto.setUSERID(userInfo.getUserID());
        
        if(userInfo.getAUTHS().equals("N")){
            result = new ApiResponse(false, "권한이 없습니다.", null);
            return ResponseEntity.badRequest().body(result);
        }

        try {
            result = new ApiResponse(true, "성공", boardService.write(writeDto));
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ApiResponse(false, e.getMessage(), null);
            return ResponseEntity.badRequest().body(result);
        }
    }

    @ApiOperation(value = "게시글 수정")
    @PutMapping("/{boaUid}/update")
    public ResponseEntity<?> boardUpdate (@PathVariable Long boaUid, @RequestBody BoardUpdateDto updateDto) {
        ApiResponse result = null;
        
        try {
            updateDto.setBOAUID(boaUid);
            result = new ApiResponse(true, "성공", boardService.update(updateDto));
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ApiResponse(false, e.getMessage(), null);
            return ResponseEntity.badRequest().body(result);
        }
    }

    @ApiOperation(value = "게시글 삭제")
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> boardDelete (@PathVariable Long boauid) {
        ApiResponse result = null;
        
        try {
            result = new ApiResponse(true, "성공", boardService.delete(boauid));
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ApiResponse(false, e.getMessage(), null);
            return ResponseEntity.badRequest().body(result);
        }
    }
}
