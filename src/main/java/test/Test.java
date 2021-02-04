package test;

import java.sql.Date;

public class Test {
  public static void main(String[] args) {
    int[] arr1 = new int[5];
    float[] arr2 = new float[5];

    // arr1[0] = 100;
    // arr1[1] = 3.14f;

    Object[] arr3 = new Object[5];

    arr3[0] = new String("hello");
    arr3[1] = new Date(System.currentTimeMillis());
    arr3[2] = new StringBuffer("Hello");
  }
}
