package com.study.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity // -> entity는 db에 있는 table을 의미한다. 따라서 db에 존재하는 table 이름과 같게 해주는게 좋다.!!
@Data // 롬복의 기능 활용 -> get, set 메서드 제작
public class Board { // table 이름과 같게 해주는게 좋다.

    @Id // primary key를 의미
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String content;

    // db에 존재하는 board라는 이름의 table의 필드를 선언해 준것.
    // 이렇게 다 한 후에는 JPA가 @Entity로 선언된 것을 읽어들여 처리한다.
}
