/**
Water Safety (#8 on Pset)
* @author MonicaChan
* @version 1.0
*/
public abstract class WaterSafety extends Transport{
  private int numberOfLifeJacket;
  private int numberOfLifeBoat;
  private int capacityOfLifeBoat;

  public WaterSafety(int t, double p, boolean fe, int lj, int lb, int c){
    super(t, p, fe);
    numberOfLifeJacket = lj;
    numberOfLifeBoat = lb;
    capacityOfLifeBoat = c;
  }

  public int getLifeJacket(){return numberOfLifeJacket;}
  public int getLifeBoat(){return numberOfLifeBoat;}
  public int getCapacityLifeBoat(){return capacityOfLifeBoat;}

  /**
  * returns true if it meets all the transport safety requirements as well as having
  enough life jackets and enough lifeboat capacity for passengers.
  * @return true if safe, false if unsafe. 
  */
  public boolean checkSafety(){
    if(super.checkSafety() && numberOfLifeJacket >= super.getTicketsSold() && numberOfLifeBoat*capacityOfLifeBoat >= super.getTicketsSold())
      return true;
    return false;
  }





}
