public class CylinderIsA extends Circle{
  private int height;
  public CylinderIsA(double radius, int h){
    super(radius);
    height = h;
  }
  public double getHeight(){return height;}
  public double getRadius(){return super.getRadius();}

  public double volume(){
    double v = super.area() * height;
    return v;
  }

  public double surfaceArea(){
    double sa = super.area()*2 + super.perimeter()*height;
    return sa;
  }

  public String toString(){
    return "Cylinder with radius " + super.getRadius() + " and height " + height;
  }

}
