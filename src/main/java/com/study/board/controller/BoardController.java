package com.study.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {


    @GetMapping("/board/write") // 어떤 url로 접근할것인지를 지정해주는 애노테이션 // localhost:8080/board/write
    public String BoardWriteForm(){

        return "boardwrite"; // "" 사이에 들어가는것은 어떤 html 파일(view 파일)로 들어갈 것인지를 알려주는것
    }
}
