package com.study.board.controller;

import com.study.board.entity.Board;
import com.study.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write") // 어떤 url로 접근할것인지를 지정해주는 애노테이션 // localhost:8080/board/write
    public String boardWriteForm(){

        return "boardwrite"; // "" 사이에 들어가는것은 어떤 html 파일(view 파일)로 들어갈 것인지를 알려주는것
    }

    @PostMapping("/board/writepro")
    public String boardWritePro(/*String title, String content*/ Board board){
        // boardwrite.html에서 form을 통해 title, content 데이터를 넘겨주고 그것들을 파라미터로 받는다.
        // 이때, 너무 많은 파라미터가 존재하면 보기 안좋고 효율 안좋다.
        // 따라서 아까 만들어 놓은 Board 클래스를 import 하고 진행

//        System.out.println("title = " + title);
//        System.out.println("content = " + content);

//        System.out.println("제목은 : " + board.getTitle());
//        System.out.println("내용은 : " + board.getContent());
        // 롬복의 @Data를 사용해서 get 메서드를 사용

        boardService.write(board);

        return "";
    }
}
// db에 저장하기 위한 레포지토리
