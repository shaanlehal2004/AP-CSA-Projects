public class SortX
{
  public static void main(String args[]){
    String[] names = {"Dan", "Alice", "Claire", "Evan", "Boris"};
    sort(names);

  }
public static void sort(String[] items)
{
int n = items.length;
while (n > 1){
sortHelper(items, n - 1);
n--;
}
}

private static void sortHelper(String[] items, int last)
{
int m = last;
for (int k = 0; k < last; k++)
{
if (items[k].compareTo(items[m]) > 0)
  m = k;
System.out.println("hi!");
String temp = items[m];
items[m] = items[last];
items[last] = temp;
}
}
}
