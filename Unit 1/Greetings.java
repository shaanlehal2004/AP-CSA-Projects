/* small program to greet user */
import java.util.Scanner;
public class Greetings {
  public static void main(String[] args){
    Scanner keyboard = new Scanner(System.in);
    System.out.print("What is your name? ");
    String name = keyboard.nextLine();
    System.out.print("How many siblings do you have? ");
    int siblings = keyboard.nextInt();
    keyboard.nextLine();
    System.out.print("Do you have a dog? ");
    String answer = keyboard.nextLine();


    System.out.println("Hello " + name);
    System.out.println("Welcome to Java!");
    System.out.println("Say hi to your " + siblings + " siblings.");
  }
}
