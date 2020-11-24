/**
Transport(#8 on Pset)
* @author MonicaChan
* @version 1.0
*/
public abstract class Transport implements Safety{
  private int numOfTicketsSold;
  private double farePerPerson;
  private boolean fireExtinguisher;

  public Transport(int n, double f, boolean fe){
    numOfTicketsSold = n;
    farePerPerson = f;
    fireExtinguisher = fe;
  }
  //Revenue is calculated by how many tickets have been sold times the price per ticket.
  public double revenue(){
    return numOfTicketsSold * farePerPerson;
  }
  public int getTicketsSold(){return numOfTicketsSold;}
  public double getFare(){return farePerPerson;}
  public boolean getExtinguish(){return fireExtinguisher;}

  /**
   * Get capacity depending of instanceof
   * @return int capacity
   */
   public int getCapacity()
   {
      if (this instanceof Bus) {return BUSCAPACITY;}
      if (this instanceof Train) {return TRAINCAPACITY;}
      if (this instanceof Plane) {return PLANECAPACITY;}
      if (this instanceof Helicopter) {return HELICOPTERCAPACITY;}
      if (this instanceof Ship) {return SHIPCAPACITY;}
      if (this instanceof Boat) {return BOATCAPACITY;}
      return 0;
   }
   
   /**
   * Returns true if transport has a fire extinguisher, and did not exceed
   the capacity of the transport.
   * @return true if safe, false if not safe.
   */
   public boolean checkSafety(){
     if(this.getExtinguish() == true && this.getTicketsSold() <= this.getCapacity())
       return true;
     return false;
   }
}
