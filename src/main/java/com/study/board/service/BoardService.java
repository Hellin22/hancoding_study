package com.study.board.service;

import com.study.board.entity.Board;
import com.study.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository; // dependency injection -> 인터페이스이기 때문에 원래는 new ~~로 객체를 생성해야하지만
    // 스프링의 autowired 어노테이션을 사용하면 알아서 읽어와서 주입을 해준다.


    //글 작성 처리
    public void write(Board board, MultipartFile file) throws IOException {

        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";

        UUID uuid = UUID.randomUUID();

        String fileName = uuid + "_" + file.getOriginalFilename();

        File saveFile = new File(projectPath, fileName);
        // saveFile 이라는 빈 껍데기를 만들고 파일이 저장될 경로와 그 파일의 새로운 이름 지정.
        file.transferTo(saveFile);
        // 업로드된 파일(file)을 새로 만든 껍데기인 saveFile로 옮기는 과정

        board.setFilename(fileName);
        board.setFilepath("/files/" + fileName);

        boardRepository.save(board);
    }

    // 게시글 리스트 처리
    public List<Board> boardList(){

        return boardRepository.findAll();
    }

    // 특정 게시글 불러오기
    public Board boardView(Integer id){
        
        return boardRepository.findById(id).get();
        // 매개변수로 id를 넣어야함.
    }

    // 특정 게시글 삭제
    public void boardDelete(Integer id){

        boardRepository.deleteById(id);
    }

} // jpa를 활용하여 테이블에 데이터 넣기
