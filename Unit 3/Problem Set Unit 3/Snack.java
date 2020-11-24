/**
Snack (#10 on Pset)
* @author MonicaChan
* @version 1.0
*/


public class Snack implements Purchase{
  private String name;
  private int calories;
  private int cost;

  public Snack(String n, int ca, int c){
    name = n;
    calories = ca;
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
  public String itemName(){return name + " has " + calories + " calories";}

  /**
  * Returns string representation of the item.
  * @return item string
  */
  public String toString(){
    return this.itemName() + " and costs " +this.cost();
  }
}
