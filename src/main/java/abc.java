import java.util.Scanner;

public class abc {
  public static void main(String[] args) {
    Scanner keyboardScan = new Scanner(System.in);
  
    final int LENGTH = 100;
    int[] nos = new int[LENGTH];
    int[] userChoice= new int[LENGTH];
    int[] status = new int[LENGTH];
    double[] heights = new double[LENGTH];
    double[] weights = new double[LENGTH];
    double[] bmis = new double[LENGTH];
    String[] names = new String[LENGTH];

    int size = 0;
    
    
    final int RLENGTH = 100;
    int[] rnos = new int[RLENGTH];
    String[] rnames = new String[RLENGTH];
    String[] rexAreas = new String[RLENGTH];
    
    int rsize = 0;
  
    loop:
      while (true) {
  
        System.out.print("명령");
        String command = keyboardScan.nextLine();
        System.out.println();

         switch (command) {

           case "/인적사항 등록":
             System.out.println("[인적사항 등록]");

             System.out.print("번호? ");
             nos[size] = Integer.parseInt(keyboardScan.nextLine());
      
             System.out.print("이름? ");
             names[size] = keyboardScan.nextLine();

             System.out.print("키? ");
             heights[size] = Double.parseDouble(keyboardScan.nextLine());

             System.out.print("몸무게? ");
             weights[size] = Double.parseDouble(keyboardScan.nextLine());
             

             bmis[size] = heights[size] / weights[size] / weights[size];
      
             System.out.println();

             size++;
             break;
      
           case "/인적사항 목록":
             System.out.println("[인적사항 목록]");
             
             for (int i = 0; i < size; i++) {
               System.out.printf("%d. %s\n", nos[i], names[i]);
             }
             System.out.println("조회할 이름을 고르세요.");
             System.out.print("> ");
             userChoice[size] = Integer.valueOf(keyboardScan.nextLine()) - 1;
      
             for(int i = 0; i < size; i++) {
        
               if(userChoice[i] < 0 && userChoice[i] > size) {
                 System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
                 System.out.print("> ");
                 userChoice[size] = Integer.valueOf(keyboardScan.nextLine()) - 1;

               }else {
                 System.out.printf("번호: %d 이름: %s\n", nos[i], names[i]);
                 System.out.printf("키: %.2f 몸무게: %.2f\n", heights[i], weights[i]);
                 System.out.printf("BMI: %.2f\n", bmis[i]);
               }
             }
             break;
      
           case "/운동루틴 등록":
             System.out.println("[운동루틴 등록]");
             
             System.out.println("번호: ");
             rnos[rsize] = Integer.parseInt(keyboardScan.nextLine());
             
             System.out.println("루틴 이름: ");
             rnames[rsize] = keyboardScan.nextLine();
             
             System.out.println("운동 부위: ");
             rexAreas[rsize] = keyboardScan.nextLine();
             
         }
      }
  }
}

