/**
* Class to define a 2-dimensional point
* @author Marie-Pierre Jolly
* @version 1.0
*/

public class Point
{
    // Class fields
    private int x, y; // we could make the fields double as well
    private String name;
    private static int numPoints = 0;

    // Constructors
    // Default no-arg constructor
    public Point()
    {
        // x = 0;
        // y = 0;
        // name = "O";
        this(0, 0, "O");
    }
    // Constructor using all parameters
    public Point(int a, int b, String s)
    {
        x = a;
        y = b;
        name = s;
        numPoints++;
    }
    // Constructor from coordinates
    public Point(int x, int y)
    {
        // this.x = x;
        // this.y = y;
        // name = "A";
        this(x, y, "A");
    }

    // Accessors
    public int getX() {return x;}
    public int getY() {return y;}
    public String getName() {return name;}

    // Modifiers
    public void setX(int a) {x = a;}
    public void setY(int b) {y = b;}
    public void setName(String s) {name = s;}

    // Calculate the slope between two points
    public double slope(Point p)
    {
        return (double)(p.y - this.y)/(p.x - this.x);
    }

    // Calculate the distance between two points
    public double distance(Point p)
    {
        double dx = (double)(p.x - this.x);
        double dy = (double)(p.y - this.y);
        return Math.sqrt(dx*dx + dy*dy);
    }

    // Get the number of instantiated points
    public static int getNumPoints()
    {
      return numPoints;
    }

    // Print a point nicely
    public String toString()
    {
      return name + "(" + x + ", " + y + ")";
    }
}
