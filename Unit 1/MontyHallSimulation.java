import java.util.Scanner;
import java.util.Random;

public class MontyHallSimulation{
  public static void main(String args[]){ // just asks user for number of run times and prints out final wins and losses.
    Scanner times = new Scanner(System.in);
    System.out.println("How many times do you want the game to run?");
    int playTimes = times.nextInt();
    int wins = 0;
    int losses = 0;
    int a = 1; //just an interating variable
    while(a <= playTimes){ //runs the Monty Hall game playTimes times.
      wins += MontyHallSimulation.montyHall(wins,losses, playTimes);

      a += 1;
    }
    System.out.println("Wins switching: " + wins); // prints number of wins switching
    losses = playTimes - wins;
    System.out.println("Losses switching: " + losses); //prints number of losses switching
    System.out.println("Wins staying: " + losses);
    System.out.println("Losses staying: " + wins);

//This next stanza of code is rounding the percentages so they're all nice and neat.
    double winProbability = (wins + 0.0)/playTimes;
    winProbability = Math.round(winProbability * 10000)/100.0; //Yes, I probably could have merged this with the line above, but I found this way less confusing.
    double loseProbability = (losses + 0.0)/playTimes;
    loseProbability = Math.round(loseProbability * 10000)/100.0;

    System.out.println("According to this trial, there is a " + winProbability + "% chance of winning by switching your door.");
    System.out.println("Additionally, there is a " + loseProbability + "% chance of winning by staying with your original door.");

  }
  public static int montyHall(int wins, int losses, int playTimes){ //Runs actual Monty Hall game and its functions.
    int prizeDoor = MontyHallSimulation.chooseDoor();
    int chooseDoor = MontyHallSimulation.chooseDoor();
    int openDoor = MontyHallSimulation.notDoor(prizeDoor, chooseDoor);
    wins = MontyHallSimulation.switchDoor(chooseDoor, prizeDoor, openDoor);
    //int newVar = MontyHallSimulation.switchDoor(chooseDoor, prizeDoor, openDoor);
    return wins;
  }

  public static int chooseDoor(){ //chooses which door the car is behind
    int chooseDoor = (int)(Math.random() * 3) + 1;
    return chooseDoor;
  }

  public static int notDoor(int doorA, int doorB){ //finds the number of the door that isn't door a or door b. helps with the reveal door and switching the door at the end.
    int i = 1;
    while(i == doorA || i == doorB){
      i = chooseDoor();
    }
    int notDoor = i;
    return notDoor;

  }
  public static int switchDoor(int userDoor, int carDoor, int openDoor){ //switches the door.
    userDoor = notDoor(userDoor, openDoor);
    int win = 0;
    if (userDoor == carDoor){
      win = 1;
    }
    return win;

  }
}
