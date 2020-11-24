import java.util.ArrayList;

public class RunnerSafety
{
  public static void main(String[] args)
  {
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

  }
}
