import java.util.Scanner;

public class Staircase{

  public static void main(String args[]){
    Scanner userInput = new Scanner(System.in);
    System.out.print("How many stars? ");
    int starNumber = userInput.nextInt();
    Staircase.regular(starNumber);
    System.out.println();
    Staircase.backwards(starNumber);
  }

  public static void regular(int n){
    for(int i=1; i <= n; i++){
      String star = "";
      for(int m=1; m <= i; m++){
        star += "*" ;
      }
      System.out.println(star);
    }
  }

  public static void backwards(int n){
    for(int i = n; i >=1; i--){
      String star = "";
      for(int m = i; m >= 1; m--){
        star += "*";
      }
      System.out.println(star);
    }
  }

}
