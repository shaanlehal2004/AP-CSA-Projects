public class Shiba extends Dog{
  private double weight;
  private String origin;
  public Shiba(int age, String color, double w, String o){
    super("Shiba", age, color);
    weight = w;
    origin = o;
  }

  public String getOrigin(){return origin;}
  public double getWeight(){return weight;}

  public void setOrigin(String newOrigin){origin = newOrigin;}
  public void setWeight(double newWeight){weight = newWeight;}

  public boolean isDoge(){
    if(origin == "Mino")
      return true;
    else
      return false;
  }

  public String toString(){
    return super.toString() + " It is " + weight + " pounds and from " + origin;
  }
}
