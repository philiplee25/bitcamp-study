// 트랜젝션 다루기 - 트랜젝션 적용 전 => auto commit 상태일 때
package com.eomcs.mybatis.ex03.e;

import java.util.HashMap;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.eomcs.mybatis.vo.Board;

public class Exam0120 {

  public static void main(String[] args) throws Exception {
    
    SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
        "com/eomcs/mybatis/ex03/e/mybatis-config.xml")).openSession();
    
    Board board = new Board();
    board.setTitle("게시글2");
    board.setContent("내용2");
    
    int count = sqlSession.insert("BoardMapper.insertBoard", board);
    System.out.printf("%d 개의 데이터를 입력했음!\n", count);
    
    HashMap<String, Object> fileInfo = new HashMap<>();
    
    // 2) 첫 번째 첨부파일 입력
    fileInfo.put("filePath", "aaa.gif");
    fileInfo.put("boardNo", board.getNo());
    count = sqlSession.insert("BoardMapper.insertFile", fileInfo);
    System.out.printf("%d 개의 데이터를 입력했음!\n", count);

    // 2) 두 번째 첨부파일 입력
    fileInfo.put("filePath", "bbb.gif");
    fileInfo.put("boardNo", board.getNo());
    count = sqlSession.insert("BoardMapper.insertFile", fileInfo);
    System.out.printf("%d 개의 데이터를 입력했음!\n", count);
    
    // 2) 세 번째 첨부파일 입력
    fileInfo.put("filePath", "0123456789012345678901234567890123456789012345678901234567890123456789"
        + "01234567890123456789012345678901234567890123456789012345678901234567890123456789012345678"
        + "90123456789012345678901234567890123456789012345678901234567890123456789012345678901234567"
        + "89012345678901234567890123456789012345678901234567890123456789012345678901234567890123456"
        + "01234567890123456789012345678901234567890123456789012345678901234567890123456789012345678"
        + "01234567890123456789012345678901234567890123456789012345678901234567890123456789012345678"
        + "01234567890123456789012345678901234567890123456789012345678901234567890123456789012345678"
        + "01234567890123456789012345678901234567890123456789012345678901234567899901234567899789.gif");
    fileInfo.put("boardNo", board.getNo());
    count = sqlSession.insert("BoardMapper.insertFile", fileInfo);
    System.out.printf("%d 개의 데이터를 입력했음!\n", count);
    
    // 수동 commit 일 때,
    // - 작업을 완료한 후 반드시 commit()을 호출해야만 실제 테이블에 변경사항을 적용한다.
    // - commit() 을 호출하지 않고 SqlSession 객체를 close() 하면 자동 rollback이다.
    // - SqlSession 객체를 재사용하는 방식이면,
    //   오류가 발생했을 때 개발자가 명시적으로 rollback()을 호출해 줘야 한다.
    
    sqlSession.commit();
    
    sqlSession.close();
    
    System.out.println("실행 완료!");
  }

}


