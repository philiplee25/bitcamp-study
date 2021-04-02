// delete 문 실행
package com.eomcs.mybatis.ex03.c;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.eomcs.mybatis.vo.Board;

public class Exam0410 {

  public static void main(String[] args) throws Exception {
    SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
        "com/eomcs/mybatis/ex03/c/mybatis-config.xml")).openSession();
    
    Board board = new Board();
    board.setTitle("제목입니다333");
    board.setContent("내용입니다333.");
    
    System.out.printf("insert 실행 전: %s\n", board);
    // insert 문을 실행한 후에 자동 증가한 PK 값을 알아내기
    // - 자동 증가한 PK 값은 SQL을 실행할 때 넘겨준 객체에 담겨있을 것이다.
    // - 단 SQL 매퍼 파일에서 insert 문을 정의할 때 설정해줘야 한다.
    
    // 예) 게시글을 입력한다.
    
    int count = sqlSession.insert("BoardMapper.insert3", board);
    System.out.printf("%d 개의 데이터를 입력했음!\n", count);

    // 현재 SqlSession 객체가 수동 commit 상태이기 때문에
    // 데이터 변경을 수행한 후 commit을 반드시 실행해야 한다.
    sqlSession.commit();
    
    sqlSession.close();
    
    System.out.printf("insert 실행 후: %s\n", board);
    System.out.println("실행 완료!");
  }

}


