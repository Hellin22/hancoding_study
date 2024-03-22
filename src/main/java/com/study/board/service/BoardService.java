package com.study.board.service;

import com.study.board.entity.Board;
import com.study.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository; // dependency injection -> 인터페이스이기 때문에 원래는 new ~~로 객체를 생성해야하지만
    // 스프링의 autowired 어노테이션을 사용하면 알아서 읽어와서 주입을 해준다.


    public void write(Board board){

        boardRepository.save(board);
    }
} // jpa를 활용하여 테이블에 데이터 넣기
