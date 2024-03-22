package com.study.board.repository;

import com.study.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // 제네릭 안에는 <어떤 엔티티, 해당 엔티티 프라이머리 키의 타입>
public interface BoardRepository extends JpaRepository<Board, Integer> { // JpaRepository는 제네릭 <> 으로 타입 지정을 해줘야한다. -> 제네릭의 정의 곱우


}
