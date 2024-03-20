package com.study.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {
    @GetMapping("/")
    @ResponseBody // return에 해당하는 "hello world"를 띄워줄 수 있게 해주는 annotation
    public String main(){

        return "hello world";
    }
}
