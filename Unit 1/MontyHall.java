import java.util.Scanner;
import java.util.Random;

public class MontyHall{
  public static void main(String args[]){
    montyHall();
  }
  public static void montyHall(){ //Runs the whole Monty Hall Game
    System.out.println("Hello! Welcome to Monty Hall. I will explain the rules. There are three doors, numbered 1 to 3. One of the doors has a car behind it, the other two have goats. I will ask you to choose a door, then I will open another door that does not have the prize. I will then ask you if you want to switch or stay, and what you choose will result in you winning a prize or a goat!");
    int prizeDoor = chooseDoor(); //Chooses which door the car is behind.
    int chooseDoor = userDoor(); //The door the user chooses.
    int openDoor = notDoor(prizeDoor, chooseDoor); //Chooses the door that gets revealed.
    System.out.println("A goat is behind " + openDoor);
    MontyHall.switchDoor(chooseDoor, prizeDoor, openDoor); //Asks user if they want to switch or not and reveals if they won.
  }
  public static int chooseDoor(){ //Chooses a random door between 1 and 3.
    int carDoor = (int)(Math.random() * 3) + 1;
    return carDoor;
  }
  public static int userDoor(){ //The door the user chooses.
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Choose a door between 1 and 3.");
    return keyboard.nextInt();
  }
  public static int notDoor(int doorA, int doorB){ //chooses the door that is revealed as well as helps with the switch function later on.
    int i = 1;
    while(i == doorA || i == doorB){ //if the number of the door isn't the same door as a or isn't the same as door b
      i = chooseDoor(); // chooses a random number between 1 and 3 to try again.
    }
    int notDoor = i;
    return notDoor;
  }
  public static void switchDoor(int userDoor, int carDoor, int openDoor){ //asks user if he/she wants to switch or stay with their decision, then prints whether they won.
    Scanner keyboard2 = new Scanner(System.in);
    System.out.println("Do you want to switch the door or stay?");
    String decision = keyboard2.nextLine();

    if (decision.equals("switch")){
      userDoor = notDoor(userDoor, openDoor); //reassigns the value of userDoor to notDoor (see notDoor function)
    }
    if (userDoor == carDoor){ //win
      System.out.println("Good job! You got the car!");
    }
    else{ //lose
      System.out.println("Oof you lost. The prize was behind door " + carDoor);
    }

  }
}
