// insert 문 실행 - Board 객체에 값을 담아 파라미터로 넘기기
package com.eomcs.mybatis.ex03.c;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.eomcs.mybatis.vo.Board;

public class Exam0110 {

  public static void main(String[] args) throws Exception {
    SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
        "com/eomcs/mybatis/ex03/c/mybatis-config.xml")).openSession();
    
    Board board = new Board();
    board.setTitle("제목입니다111");
    board.setContent("내용입니다111.");
    
    // insert 문을 실행할 때는 insert() 메서드를 호출한다.
    // - 리턴 값은 executeUpdate()의 실행 결과이다.
    // - 즉 insert 된 데이터의 개수이다.
    int count = sqlSession.insert("BoardMapper.insert1", board);
    System.out.printf("%d 개의 데이터를 입력했음!\n", count);

    // 현재 SqlSession 객체가 수동 commit 상태이기 때문에
    // 데이터 변경을 수행한 후 commit을 반드시 실행해야 한다.
    sqlSession.commit();
    
    sqlSession.close();
    System.out.println("실행 완료!");
  }

}


