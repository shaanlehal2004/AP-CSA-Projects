import java.util.ArrayList;

class Test1{
  public String toString(){
    return "a pen";
  }
}

public class hello{
  public static void main(String args[]){
    ArrayList<Object> arr = new ArrayList<Object>();
    arr.add("String");
    arr.add(2);
    arr.add(new Test1());
    Test1 p = arr.get(2);
    System.out.println(p);
  }
}
