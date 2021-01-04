package com.project.study.web.board;

import com.project.study.service.BoardService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequiredArgsConstructor
@CrossOrigin("*")
@Controller
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("board", boardService.board());
        return "main";
    }
    
}
