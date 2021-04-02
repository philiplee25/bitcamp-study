// SqlSession 사용법 - selectOne()의 리턴 값을 Map 객체로 받기
package com.eomcs.mybatis.ex02.f;

import java.util.Map;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.eomcs.mybatis.vo.Board;

public class Exam0130 {

  public static void main(String[] args) throws Exception {
    SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
        "com/eomcs/mybatis/ex02/f/mybatis-config.xml")).openSession();

    // Map 객체로 받으려면 SQL 매퍼에서 다음과 같이 설정해야 한다.
    //    <select id="selectBoard3" resultType="map" parameterType="int">
    //    select 
    //     board_id,
    //     title,    
    //     contents,
    //     created_date, 
    //     view_count  
    //    from x_board
    //    where board_id=#{no}
    //  </select>
    
    // - 컬럼 이름이나 컬럼 값을 저장하기 때문에
    //   map 객체에 컬럼 값을 꺼낼 때 컬럼 이름을 사용해야 한다.
    
    Map<String, Object> map = sqlSession.selectOne("BoardMapper.selectBoard3", 5);
    
    if (map == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    // 컬럼명과 자바 객체의 프로퍼티명이 일치한다면 다음과 같이 정상적으로 데이터를 꺼내올 수 있다.
     System.out.printf("%d,%s,%s,%s,%d\n",
          map.get("board_id"),
          map.get("title"),
          map.get("contents"),
          map.get("created_date"),
          map.get("view_count"));
    
    sqlSession.close();
  }

}


