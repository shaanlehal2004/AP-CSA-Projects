// The IsVehicle interface
interface IsVehicle
{
  public String getName();
  public void   setName(String aName);
  public int    getMaxPassengers();
  public void   setMaxPassengers(int aMaxPassengers);
  public int    getMaxSpeed();
  public void   setMaxSpeed(int aMaxSpeed);
}

// The IsLandVehicle interface
interface IsLandVehicle extends IsVehicle
{
  public int  getNumWheels();
  public void setNumWheels(int aNumWheels);
  public void drive();
}

// The IsSeaVessel interface
interface IsSeaVessel extends IsVehicle
{
  public int  getDisplacement();
  public void setDisplacement(int aDisplacement);
  public void launch();
}

interface IsEmergency extends IsVehicle{
  public void soundSiren();
}

public class Runner
{
  public static void main(String[] args)
  {
    IsVehicle[] myArray = new IsVehicle[4];

    myArray[0] = new Jeep("Fred's Jeep");
    myArray[1] = new PoliceCar("Frank's Police Car");
    myArray[2] = new Hovercraft("Sue's Hovercraft");
    myArray[3] = new Frigate("Money Waster");

    for (int i=0; i<myArray.length; i++)
    {
      System.out.println(myArray[i].getName());
      if (myArray[i] instanceof IsLandVehicle)
      {
        IsLandVehicle lv = (IsLandVehicle)myArray[i];
        lv.drive();
      }
      if(myArray[i] instanceof IsEmergency){
        IsEmergency ie = (IsEmergency)myArray[i];
        ie.soundSiren();
      }
      if (myArray[i] instanceof IsSeaVessel)
      {
        IsSeaVessel sv = (IsSeaVessel)myArray[i];
        sv.launch();
      }
    }
  }
}
