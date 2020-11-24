import java.util.ArrayList;


public class Poop{
  public static void main(String args[]){
    ArrayList<Integer> aInt = new ArrayList<Integer>();
aInt.add(3);
aInt.add(0, Integer.valueOf(5));
aInt.add(-4);
int i = aInt.remove(1);
aInt.set(1, -5);
System.out.println(aInt);
  }

  public static String encrypt(String word)
{
  int pos = word.length() / 2;
  if (pos >= 1)
  {
    word = encrypt(word.substring(pos)) + encrypt(word.substring(0, pos));
  }
  return word;
}

}
