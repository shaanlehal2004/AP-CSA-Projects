public class RoadBike extends Bicycle
{
  private int tireWidth;
  private double weight;

  public RoadBike(int width, double bikeWeight, int startCadence, int startSpeed, int startGear){
    super(startCadence, startSpeed, startGear);
    tireWidth = width;
    weight = bikeWeight;
  }

  public void toString(){
    return super.toString() + " weight = " + weight + " tireWidth = " + tireWidth;
  }

}
