import java.util.Scanner;


public class FloydTriangle{
  public static void main(String args[]){
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Enter the number of numbers you want in your floyd triangle.");
    int elements = keyboard.nextInt();
    System.out.println();
    int n = 0;
    for(int i = 1; i <= elements; i++){
      System.out.println();
      for(int m = 0; m < i; m++){
        System.out.print(++n + " ");
      }
    }
  }
}
