// SqlSession 사용법 - 결과 타입이 Map 일 때
package com.eomcs.mybatis.ex02.e;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.eomcs.mybatis.vo.Board;

public class Exam0110 {

  public static void main(String[] args) throws Exception {
    SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
        "com/eomcs/mybatis/ex02/e/mybatis-config.xml")).openSession();

    // 결과 타입이 Map 이면,
    // - selectList()의 리턴 타입은 List<Map> 이 된다.
    
    List<Map> list = sqlSession.selectList("BoardMapper.selectBoard");

    // 각각의 Map 객체에는 레코드 값이 보관된다.
    // - 즉 레코드의 각 컬럼 값이 Map 객체에 보관된다.
    for (Map<K, V> map : list) {
      System.out.printf("%d,%s,%s,%s,%d\n",
          map.get("board_id"),
          map.get("title"),
          map.get("contents"),
          map.get("created_date"),
          map.get("view_count"));
    }

    sqlSession.close();
  }

}


