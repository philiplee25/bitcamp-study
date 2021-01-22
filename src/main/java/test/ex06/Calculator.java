package test.ex06;

public class Calculator {

  int result;

  void plus(int value) {
    // Calculator this; 숨겨진 내장 변수
    this.result += value; // this 생략가능
  }

  void minus(int value) {
    this.result -= value;
  }

  void multiple(int value) {
    this.result *= value;
  }

  void divide(int value) {
    this.result/= value;
  }
}
