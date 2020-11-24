public class CylinderHasA{
  private Circle circle;
  private int height;
  public CylinderHasA(double radius, int height){
    circle = new Circle(radius);
    this.height = height;
  }
  public double getRadius(){return circle.getRadius();}
  public int getHeight(){return height;}

  public double volume(){
    return circle.area()*height;
  }

  public double surfaceArea(){
    return circle.area()*2+circle.perimeter()*height;
  }

}
