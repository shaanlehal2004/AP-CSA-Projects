class Truck extends Vehicle
{
  private int weight;

  public Truck(int wh, int we)
  {
    numWheels = wh;
    weight = we;
  }

  public int getWeight()
  {
    return weight;
  }
}
