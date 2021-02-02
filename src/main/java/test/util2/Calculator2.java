package test.util2;

import test.util.Calculator;

public class Calculator2 extends Calculator{

  public void minus(int value) {
    this.result -= value;
  }

  // 파라미터 변수명은 상관없고 개수, 순서, 타입에 따라 오버로딩이 달라진다.
  //  public void minus(int a) {
  //    this.result -= a;
  //  }

  public void minus(int value1, int value2) {
    this.result -= value1;
    this.result -= value2;
  }

  public void plus(int a, int b) {
    this.result += a;
    this.result += b;
  }
}
