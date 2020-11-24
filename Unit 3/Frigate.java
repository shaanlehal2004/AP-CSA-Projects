// The Frigate class
class Frigate implements IsSeaVessel
{
  // Fields
  private String name;
  private int    maxPassengers;
  private int    maxSpeed;
  private int    displacement;

  // Constructor
  public Frigate(String aName)
  {
    name          = aName;
    maxPassengers = 100;
    maxSpeed      = 12;
    displacement  = 10000;
  }

  // IsVehicle methods
  public String getName() {return name;}
  public void setName(String aName) {name = aName;}
  public int getMaxPassengers() {return maxPassengers;}
  public void setMaxPassengers(int aMaxPassengers) {maxPassengers = aMaxPassengers;}
  public int getMaxSpeed() {return maxSpeed;}
  public void setMaxSpeed(int aMaxSpeed) {maxSpeed = aMaxSpeed;}

  // IsSeaVessel methods
  public int getDisplacement() {return displacement;}
  public void setDisplacement(int aDisplacement) {displacement = aDisplacement;}
  public void launch() {System.out.println("Frigate launched!");}

  // Frigate methods
  public void fireGun() {System.out.println("Boom!");}
}
