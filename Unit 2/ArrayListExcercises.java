import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExcercises{
  public static void main(String args[]){
    /* TESTS FOR doubleArray
    Scanner keyboard = new Scanner(System.in);
    ArrayList<Integer> nums = new ArrayList<Integer>();
    System.out.println("Put in an arbitrary number of integers, type end to stop adding");
    String s = keyboard.nextLine();
    int response;
    while(!(s.equals("end"))){
      response = Integer.parseInt(s);
      nums.add(response);
      s = keyboard.nextLine();
    }
    int i = doubleArray(nums);
    System.out.println(i);
    */

    ArrayList<String> stringy = new ArrayList<String>(4);
    stringy.add("cheese");
    stringy.add("cheddar");
    stringy.add("gouda" );
    stringy.add( "cheddar");
    System.out.println(removeOccurence(stringy, "cheddar"));
  }

  public static int doubleArray(ArrayList<Integer> list){
    int temp;
    int largest = list.get(0);
    for(int i = 0; i < list.size(); i++){
      temp = list.get(i) * 2;
      list.set(i, temp);

      if(largest < temp)
        largest = temp;
    }
    return largest;
  }

  public static ArrayList<String> removeOccurence(ArrayList<String> list, String remove){
    for(int i = 0; i<list.size(); i++){
      if(list.get(i).equals(remove))
        list.remove(i);
    }
    return list;
  }
  
}
