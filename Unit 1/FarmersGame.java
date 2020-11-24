
/**
* @author MonicaChan
* @version 1.0
*/

import java.util.Scanner;


public class FarmersGame{

  public static void main(String args[]){

    boolean[] side1 = {true, true, true, true};
    boolean[] side2 = {false, false, false, false};
    // index 0 is Farmer
    // index 1 is Wolf
    // index 2 is Cabbage
    // index 3 is Sheep
    String[] elements = {"Farmer", "Wolf", "Cabbage", "Sheep"};

    /*
    General strategy: when all the elements of array side1 are false, then the game is won.
    Use the elements array to check and make moves.
    */

    //game will run while play is true, end when play is false.
    boolean play = true;
    while(play == true){
      printStatus(side1, elements);
      String i = inputFromUser();
      move(i, elements, side1, side2);
      play = isSomethingEaten(side1);

      //checks if the game is won after every round.
      if(play == true)
        play = IsTheGameWon(side1);
    }
    //prints the river at the end of the game, win or lose.
    printStatus(side1, elements);
    System.out.println();
  }

  /**
  * @param a the array of booleans for side 1.
  * @param elements the array of elements containing Farmer, Wolf, Cabbage, Sheep
  */
  //Prints the state of the river.
  public static void printStatus(boolean[] a, String[] elements){
    String s1 = "";
    String s2 = "";
    for(int i = 0; i < a.length; i++){
      //if the elements are on that side (aka true for that side) add it to the string of that side.
      if( a[i] == true) {
        s1 += elements[i] + " ";
      }
      else {
        s2 += elements[i] + " ";
      }
    }
    System.out.println(s1);
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println(s2);
    }

  /**
  * @return the string the user inputs for what they want to move.
  */
  //Asks the user what they want to move to the other side.
  public static String inputFromUser(){
    Scanner keyboard = new Scanner(System.in);
    System.out.println("What would you like to take to the other side?");
    String input = keyboard.nextLine();
    System.out.println();
    return input;

  }

  /**
  * @param bool the boolean array for side 1.
  * @return boolean that represents losing or winning, it returns to variable play, so if play is false, game ends.
  */
  //Checks if the move made the game lose.
  public static boolean isSomethingEaten(boolean[] bool){
       //checks if the wolf and sheep are left alone without the farmer, or if sheep and cabbage are left alone.
       if(((bool[1] == bool[3]) && bool[0] != bool[1]) || ((bool[2] == bool[3]) && bool[0]!= bool[2])){
         System.out.println("******You lost! Try again*****");
         System.out.println();
          //return false to play, so game ends.
         return false;
       }
       else
        //continue play, play is still true.
        return true;

   }

   /**
   * @param bool1 the boolean array for side 1.
   * @return boolean that returns to play, if play is false, the game ends.
   */
   //checks if the game is won by calling the function to detect if all elements in the first side are false.
  public static boolean IsTheGameWon(boolean[] bool1){
    boolean won = equalArray(bool1);
    if(won == true){
      System.out.println("Congrats you won!");
      return false;
    }
    else
      return true;

  }

  /**
  * @param x the input string from the user
  * @param elements the array containing the Farmer, Sheep, Wolf, and Cabbage.
  * @param bool1 the array containing booleans for side 1
  * @param bool2 the array containing booleans for side 2
  */
  //the function that switches the side of the element.
  public static void move(String x, String[] elements, boolean[] bool1, boolean[] bool2){

    //searches for the element that matches the input.
    for(int i = 1; i < elements.length; i++){
        if(x.equals("Farmer")){
          bool1[0] = !bool1[0];
          bool2[0] = !bool2[0];
        }
        else if(elements[i].equals(x)){
          if(bool1[0] == bool1[i]){
            bool1[i] = !bool1[i];
            bool2[i] = !bool2[i];
            bool1[0] = !bool1[0];
            bool2[0] = !bool2[0];
          }

          //if the user puts in an element that is on the other side than the farmer.
          else
            System.out.println("*****Please put a valid input in, that element is not on your side*****");
            System.out.println();
        }
    }
  }


  /**
  * @param a a boolean array that is being tested for all elements being false.
  * @return boolean that represents if all the elements in an array are false or not. true if it is, false if it isn't.
  */

  //checks if all the elements in the array are false.
  public static boolean equalArray(boolean[] a){

    if((a[0] == a[1] && a[1] == a[2] && a[2] == a[3]) && a[0] == false)
      return true;

    else
      return false;
    }


  }
