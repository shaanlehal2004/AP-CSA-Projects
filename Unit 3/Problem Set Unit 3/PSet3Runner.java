import java.util.ArrayList;
public class PSet3Runner{
  public static void main(String args[]){

    System.out.println("-----------TESTS FOR COMPLEX----------");
    Complex a = new Complex();
    Complex b = new Complex(3, 2);
    System.out.println("a = " + a);
    System.out.println("a's modulus = "+ a.modulus());
    System.out.println("a's angle = " + a.angle());
    System.out.println("b =" + b);
    System.out.println("b's modulus = " + b.modulus());
    System.out.println("b's angle = " + b.angle());
    System.out.println("------------TESTS FOR QUBIT-------------");
    Qubit c = new Qubit();
    Qubit d = new Qubit(a, b);
    System.out.println("c = " + c.toString());
    System.out.println("c's state = " + c.measure());
    System.out.println("d = " + d.toString());
    System.out.println("d's state = " + d.measure());


    System.out.println("-----------------TESTS FOR HUMAN------------");
    ArrayList<Human> arr = new ArrayList<Human>();
    arr.add(new Man());
    arr.add(new Woman());
    arr.add(new Man());
    // The following statement should print: "man eats steak"
    System.out.println(arr.get(0).eat("steak"));
    // The following statement should print: "woman eats salad"
    System.out.println(arr.get(1).eat("salad"));


    System.out.println("---------------TESTS FOR DATE--------------");
    Date jan1 = new Date(2019,1, 1);
    System.out.print(jan1.getYear() + " ");
    System.out.print(jan1.getMonth() + " ");
    System.out.println(jan1.getDay() + " ");
    System.out.println(jan1.getDayOfWeek());
    System.out.println(jan1);
    System.out.println(jan1.nextDay());


    Date feb29 = new Date(2020, 2, 29);
    System.out.print(feb29.getYear() + " ");
    System.out.print(feb29.getMonth() + " ");
    System.out.println(feb29.getDay() + " ");
    System.out.println(feb29);
    System.out.println(feb29.nextDay());
    System.out.println(feb29.getDayOfWeek());

    System.out.println("Is 2019 a leap year? " + Date.isLeapYear(2019));
    System.out.println("Is 2020 a leap year? " + Date.isLeapYear(2020));
    System.out.println("Is 2000 a leap year? " + Date.isLeapYear(2000));

    System.out.println(Date.isValidDate(2003, 1, 22));
    System.out.println(Date.isValidDate(2000, 13, 29));
    System.out.println(Date.isValidDate(2019, 12, 50));
    System.out.println(Date.isValidDate(100000, 12, 12));


  System.out.println("--------------TESTS FOR SONG---------------");
  Top10Songs mySongs = new Top10Songs();
  Song S1 = new Song("Let It Be", "The Beatles");
  Song S2 = new Song("Satisfaction", "The Rolling Stones");
  Song S3 = new Song("Hello", "Adele");
  Song S4 = new Song("The Piano Man", "Billy Joel");
  Song S5 = new Song("The Candle In The Wind", "Elton John");
  Song S6 = new Song("Bohemian Rhapsody", "Queen");
  Song S7 = new Song("Thriller", "Michael Jackson");
  Song S8 = new Song("Live To Tell", "Madonna");
  Song S9 = new Song("Purple Rain", "Prince");
  Song S10 = new Song("New York, New York", "Frank Sinatra");
  Song S11 = new Song("My Heart Will Go On", "Celine Dion");
  System.out.println("----- add S1 --> " + mySongs.add(S1));
  System.out.print(mySongs);
  System.out.println("----- add S2 at 4 --> " + mySongs.add(S2, 4));
  System.out.print(mySongs);
  System.out.println("----- add S3 at 7 --> " + mySongs.add(S3, 7));
  System.out.print(mySongs);
  System.out.println("----- add S4 --> " + mySongs.add(S4));
  System.out.print(mySongs);
  System.out.println("----- add S5 --> " + mySongs.add(S5));
  System.out.print(mySongs);
  System.out.println("----- add S6 at 3 --> " + mySongs.add(S6, 3));
  System.out.print(mySongs);
  System.out.println("----- add S7 --> " + mySongs.add(S7));
  System.out.print(mySongs);
  System.out.println("----- add S8 --> " + mySongs.add(S8));
  System.out.print(mySongs);
  System.out.println("----- add S9 --> " + mySongs.add(S9));
  System.out.print(mySongs);
  System.out.println("----- add S10 --> " + mySongs.add(S10));
  System.out.print(mySongs);
  System.out.println("----- add S11 --> " + mySongs.add(S11));
  System.out.print(mySongs);
  System.out.println("----- add S11 at 2 --> " + mySongs.add(S11, 2));
  System.out.print(mySongs);
  System.out.println();


  System.out.println("---------------TESTS FOR POETRY-----------");
  Haiku haiku = new Haiku();
  System.out.println("haiku");
  System.out.println(haiku.numLines());
  System.out.println(haiku.getSyllables(1));
  System.out.println(haiku.getSyllables(2));
  System.out.println(haiku.getSyllables(3));
  System.out.println(haiku.printRhythm());
  Limerick limerick = new Limerick();
  System.out.println();
  System.out.println("limerick");
  System.out.println(limerick.numLines());
  System.out.println(limerick.getSyllables(1));
  System.out.println(limerick.getSyllables(2));
  System.out.println(limerick.getSyllables(3));
  System.out.println(limerick.getSyllables(4));
  System.out.println(limerick.getSyllables(5));
  System.out.println(limerick.printRhythm());



  System.out.println("------------TESTS FOR  SAVINGS ACCOUNT--------------");
  System.out.println("bob");
  SavingsAccount bob = new SavingsAccount();
  System.out.println(bob.getSavingsBalance());
  System.out.println(bob.calculateMonthlyInterest());
  bob.modifyInterestRate(.3);
  System.out.println(bob.calculateMonthlyInterest());
  System.out.println("jane");
  SavingsAccount jane = new SavingsAccount(1000);
  System.out.println(jane.getSavingsBalance());
  System.out.println(jane.calculateMonthlyInterest());
  jane.modifyInterestRate(.5);
  System.out.println(jane.calculateMonthlyInterest());



  System.out.println("----------------SAFETY TESTS---------------");
  ArrayList<Safety> transportOperations = new ArrayList<Safety>();
    // 25 tickets sold, $5 per ticket, and has a fire extinguisher on board
    transportOperations.add(new Bus(25, 5, true));
    // 200 tickets sold, $25 per ticket
    transportOperations.add(new Train(200, 25));
    // 100 tickets sold, $375 per ticket, and a fire extinguisher on board,
    // 150 lifejackets, 30 lifeboats which can carry 5 people per lifeboat
    transportOperations.add(new Plane(100, 375, true, 150, 30, 5));
    // 105 tickets sold, $370 per ticket
    transportOperations.add(new Plane(105, 370));
    // 15 tickets sold, $500 per ticket, and has a fire extinguisher on board
    transportOperations.add(new Helicopter(15, 500, true));
    // 90 tickets sold, $150 per ticket, and has a fire extinguisher on board
    transportOperations.add(new Ship(90, 150, true));
    // 25 tickets sold, $450 per ticket, and has a fire extinguisher on board,
    // 25 lifejackets, 5 lifeboats which can carry 5 people per lifeboat
    transportOperations.add(new Helicopter(25, 450, true, 25, 5, 5));
    // 5 tickets sold, $500 per ticket
    transportOperations.add(new Boat(5, 500));
    // 12 tickets sold, $250 per ticket, no fire extinguisher on board,
    // 20 lifejackets, 5 lifeboats which can carry 4 people per lifeboat
    transportOperations.add(new Boat(12, 250, false, 25, 5, 4));

    Operations current = new Operations(transportOperations);
    // Find out how many transport operations pass the safety test
    System.out.println(current.getSafeOperations());
    // Find out the total revenue for all operations that pass the safety test
    System.out.println(current.totalRevenue());
    // Find out the total Land transport operation revenue for all Land
    // transport operations that pass the safety test
    System.out.println(current.totalLandRevenue());
    // Find out the total Air transport operation revenue for all Air
    // transport operations that pass the safety test
    System.out.println(current.totalAirRevenue());
    // Find out the total Sea transport operation revenue for all Sea
    // transport operations that pass the safety test
    System.out.println(current.totalSeaRevenue());



    System.out.println("----------TESTS FOR LEAGUE---------------");
    String[] teams = {"Pingry", "Gill", "Newark Academy", "Lawerenceville"};
    League bestLeague = new League(teams);

    bestLeague.playGame(new Game(bestLeague.getTeam(0), bestLeague.getTeam(1), 20, 10));
    bestLeague.playGame(new Game(bestLeague.getTeam(0), bestLeague.getTeam(2), 30, 0));
    bestLeague.playGame(new Game(bestLeague.getTeam(0), bestLeague.getTeam(3), 20, 19));
    bestLeague.playGame(new Game(bestLeague.getTeam(1), bestLeague.getTeam(2), 10, 20));
    bestLeague.playGame(new Game(bestLeague.getTeam(1), bestLeague.getTeam(3), 0, 30));
    bestLeague.playGame(new Game(bestLeague.getTeam(2), bestLeague.getTeam(3), 20, 15));
    System.out.println("Number of games played in the league: " + Game.getNumGames());
    System.out.println("Pingry's wins: " + bestLeague.getTeam(0).getNumWins());
    System.out.println("Gill's wins: " + bestLeague.getTeam(1).getNumWins());
    System.out.println("Newark Academy's wins: " + bestLeague.getTeam(2).getNumWins());
    System.out.println("Lawerenceville's wins: " + bestLeague.getTeam(3).getNumWins());
    System.out.println("The Champion is: " + bestLeague.getChampion());

    System.out.println("--------------SHOPPER TESTS---------------");
    Shopper henry = new Shopper("Henry");
    System.out.println("The shopper's name is: " + henry.getName());
    Money quarter = new Money(25);
    System.out.println(quarter.getName() + " " + quarter.getValue());
    Money dime = new Money(10);
    Money nickel = new Money(5);
    Money penny = new Money(1);
    henry.addCoin(quarter);
    henry.addCoin(dime);
    henry.addCoin(nickel);
    henry.addCoin(penny);
    henry.addCoin(quarter);
    henry.addCoin(dime);
    henry.addCoin(nickel);
    henry.addCoin(penny);
    henry.addCoin(quarter);
    henry.addCoin(dime);
    henry.addCoin(nickel);
    henry.addCoin(penny);
    System.out.println("Shopper has: " + henry.getTotalValue());

    Book harryPotter = new Book("Harry Potter", "JK Rowling", 100);
    Snack apple = new Snack("Apple", 60, 50);
    Snack chips = new Snack("Chips", 120, 100);
    henry.buy(apple);
    System.out.println("Shopper bought an apple for " + apple.cost());
    System.out.println("Shopper has: " + henry.getTotalValue());
    henry.addCoin(dime);
    henry.addCoin(dime);
    henry.addCoin(dime);
    System.out.println("Shopper has: " + henry.getTotalValue());
    henry.buy(harryPotter);
    System.out.println("Shopper bought Harry Potter for " + harryPotter.cost());

    System.out.println(henry);

  }
}
