public class Segment{
  // Fields 2 points.
  //Constructors
  private Point a,b;
  private int x1, x2, y1, y2;

  public Segment(Point a, Point b){
    this.a = a;
    this.b = b;
    this.x1 = a.getX();
    this.y1 = a.getY();
    this.x2 = b.getX();
    this.y2 = b.getY();
  }

  public Segment(int x1, int y1, int x2, int y2){
    this.a = new Point(x1, y1);
    this.b = new Point(x2, y2);
    this.x1 = a.getX();
    this.y1 = a.getY();
    this.x2 = b.getX();
    this.y2 = b.getY();

  }

  //method length of segment
  public double Length(){
    double length = Math.sqrt(Math.pow(this.x2-this.x1, 2)+ Math.pow(this.y2-this.y1,2));
    return length;
  }

  public String toString(){
    return "(" + this.a + ") " + "(" + this.b + ")";
  }

}
