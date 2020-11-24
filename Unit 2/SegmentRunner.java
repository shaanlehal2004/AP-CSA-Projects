public class SegmentRunner{
  public static void main(String args[]){
    Point a = new Point(4,5);
    Point b = new Point(2,6);
    Segment fsegment = new Segment(a, b);
    System.out.println(fsegment.Length());
    String newString = fsegment.toString();
    System.out.println(newString);
  }
}
