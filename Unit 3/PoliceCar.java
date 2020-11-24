public class PoliceCar implements IsEmergency, IsLandVehicle{
  private String name;
  private int    maxPassengers;
  private int    maxSpeed;
  private int numWheels;

  public PoliceCar(String s){
    name = s;
    maxPassengers = 5;
    maxSpeed = 150;
    numWheels = 4;
  }

  //IsVehicle stuffs
  public String getName() {return name;}
  public void setName(String aName) {name = aName;}
  public int getMaxPassengers() {return maxPassengers;}
  public void setMaxPassengers(int aMaxPassengers) {maxPassengers = aMaxPassengers;}
  public int getMaxSpeed() {return maxSpeed;}
  public void setMaxSpeed(int aMaxSpeed) {maxSpeed = aMaxSpeed;}



  public void setNumWheels(int b){numWheels = b;}
  public int getNumWheels(){return numWheels;}
  public void drive(){System.out.println("Drivin and vibin");}

  //PoliceCar stuffs
  public void soundSiren(){System.out.println("beedobeedobeedo!!");}

}
