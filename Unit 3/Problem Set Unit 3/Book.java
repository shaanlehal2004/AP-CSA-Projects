/**
Book (#10 on Pset)
* @author MonicaChan
* @version 1.0
*/

public class Book implements Purchase{
  private String title;
  private String author;
  private int cost;

  public Book(String t, String a, int c){
    title = t;
    author = a;
    cost = c;
  }

  /**
  * returns an int representing the cost, in cents
  * @return the cost of the item.
  */
  public int cost(){return cost;}

  /**
  *Returns the name of the item as a String
  * @return the name of the item
  */
  public String itemName(){return title + " by " + author;}

  /**
  * Returns string representation of the item.
  * @return item string
  */
  public String toString(){
    return this.itemName() + " and costs " +this.cost();
  }
}
