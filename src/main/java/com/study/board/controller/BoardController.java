package com.study.board.controller;

import com.study.board.entity.Board;
import com.study.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write") // 어떤 url로 접근할것인지를 지정해주는 애노테이션 // localhost:8080/board/write
    public String boardWriteForm(){

        return "boardwrite"; // "" 사이에 들어가는것은 어떤 html 파일(view 파일)로 들어갈 것인지를 알려주는것
    }

    @PostMapping("/board/writepro")
    public String boardWritePro(Board board, Model model, MultipartFile file) throws IOException {

        boardService.write(board, file);

        model.addAttribute("message", "등록이 성공적으로 완료");
        model.addAttribute("searchUrl", "/board/list");

        return "message";
        // return "redirect:/board/list";
    }

    @GetMapping("/board/list")
    public String boardList(Model model){

        model.addAttribute("list", boardService.boardList());
        // boardService.boardList()를 하면 List<board>가 반환되는데 그걸 "list"라는 이름으로 뷰 템플릿에 넘기겠다는 의미

        return "boardlist";
    }

    @GetMapping("/board/view") // localhost:8080/board/view?id=1 -> 1번 게시글로 이동함.
    public String boardView(Model model, Integer id){

        model.addAttribute("board", boardService.boardView(id));

        return "boardview";
    }

    @GetMapping("/board/delete") // localhost:8080/board/delete?id=1
    public String boardDelete(Integer id,
                              Model model){

        model.addAttribute("message", "삭제가 성공적으로 완료");
        model.addAttribute("searchUrl", "/board/list");

        boardService.boardDelete(id);
        return "message";
        // return "redirect:/board/list";
    }

    @GetMapping("/board/modify/{id}")
    public String boardModify(@PathVariable("id") Integer id,
                              Model model){

        model.addAttribute("board", boardService.boardView(id));
        return "boardmodify";
    }

    @PostMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable("id") Integer id,
                              Board board,
                              Model model,
                              MultipartFile file) throws IOException{

        Board boardTmp = boardService.boardView(id);
        boardTmp.setTitle(board.getTitle());
        boardTmp.setContent(board.getContent());

        boardService.write(boardTmp, file);

        model.addAttribute("message", "수정이 성공적으로 완료");
        model.addAttribute("searchUrl", "/board/list");
        return "message";
        // return "redirect:/board/list";
    }
}
// db에 저장하기 위한 레포지토리
