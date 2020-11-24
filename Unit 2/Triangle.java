public class Triangle{


  private Segment segA, segB, segC;

  public static Triangle(){
    this.segA =  segA;
    this.segB = segB;
    this.segC = segC;
  }

  public String toString(){
    return "A " + segA.toString() + " B " + segB.toString() + " C " + segC.toString();
  }

  public double calculatePerimeter(){
    return segA.Length() + segB.Length() + segC.Length();
  }
}
