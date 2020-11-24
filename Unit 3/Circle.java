
public class Circle{
  private double radius;
  public Circle(double r){
    radius = r;
  }
  public double getRadius(){return radius;}
  public void setRadius(double r){radius = r;}

  public double perimeter(){
    double perimeter = 2*Math.PI*radius;
    return perimeter;
  }

  public double area(){
    double area = Math.PI*(Math.pow(radius, 2));
    return area;
  }

  public String toString(){
    return "Circle with radius " + radius;
  }
}
