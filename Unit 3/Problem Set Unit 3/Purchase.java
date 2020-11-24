/**
Purchase (#10 on Pset)
* @author MonicaChan
* @version 1.0
*/
public interface Purchase{
  /**
  * returns an int representing the cost, in cents
  * @return the cost of the item.
  */
  public int cost();

  /**
  *Returns the name of the item as a String
  * @return the name of the item 
  */
  public String itemName();

}
