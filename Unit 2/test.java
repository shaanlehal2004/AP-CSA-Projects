import java.util.ArrayList;
public class test{
  public static void main(String args[]){
    ArrayList words = new ArrayList();
words.add("Dislikes");
words.add("likes");
words.add("likes");
for(int i = 0; i < words.size(); i++)
{
  if ("likes".equals(words.get(i)))
    words.remove(i);
}
System.out.println(words);
  }

}
