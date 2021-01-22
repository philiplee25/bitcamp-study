package test.ex02;

public class App3 {
  public static void main(String[] args) {

    // 인스턴스와 가비지
    MyClass v1 = new MyClass();
    v1.b = 300;
    System.out.println(v1.b);

    //다음과 같이 새 인스턴스를 만든 다음에
    // 그 주소를 v1에 저장하면
    // 이전 인스턴스의 주소는 잃어버린다. - 주소가 없어 사용할 수 없는 인스턴스 = 가비지

    v1 = new MyClass();
    System.out.println(v1.b);

  }
}
