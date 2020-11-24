/**
Shopper (#10 on Pset)
* @author MonicaChan
* @version 1.0
*/
import java.util.ArrayList;


public class Shopper{
  private String name;
  private ArrayList<Money> coins;
  private ArrayList<Purchase> purchases;

  public Shopper(String n){
    name = n;
    coins = new ArrayList<Money>();
    purchases = new ArrayList<Purchase>();
  }

  public String getName(){return name;}
  public ArrayList<Purchase> getPurchases(){return purchases;}
  public ArrayList<Money> getCoins(){return coins;}

  /**
  *adds money to the list of coins that the shopper has.
  * @param m is the coin to be added to the coin array list.
  */
  public void addCoin(Money m){
    coins.add(m);
  }

  /**
  *returns the total value (in cents) of all coins that the shopper has.
  * @return the total amount of money.
  */
  public int getTotalValue(){
    int v = 0;
    for(int i = 0; i < coins.size(); i++){
      v+= coins.get(i).getValue();
    }
    return v;
  }

  /**
  *attempts to add p to the list of purchases, assuming that the shopper has
  enough funds. If the shopper has enough funds, subtract the appropriate coins,
  replace with the necessary change, and return true. For example, if you
  purchase something for 8 cents and only have a quarter, you should remove the
  quarter and replace it with a dime, a nickel and 2 pennies. If the shopper does
  not have enough funds, return false.
  * @param p is the item to buy.
  * @return true if the purchase was executed, false if it failed.
  */
  public boolean buy(Purchase p){
    int balance = this.getTotalValue();
    int pay = 0;
    if(balance < p.cost()){
      return false;
    }
    else{
      while(pay < p.cost()){
        pay += coins.get(0).getValue();
        coins.remove(0);
      }
      int change = pay - p.cost();
      if(pay != 0){
        int quarters = change / 25;
        change = change % 25;
        this.addMultipleCoins(quarters, "Quarter");
        int dimes = change / 10;

        change = change % 10;
        this.addMultipleCoins(dimes, "Dime");
        int nickels = change / 5;

        change = change % 5;
        this.addMultipleCoins(nickels, "Nickel");
        int pennies = change;
        
        this.addMultipleCoins(pennies, "Penny");
      }
    }
    purchases.add(p);
    return true;
  }

  public void addMultipleCoins(int numCoins, String type){
    Money coin;
    if(type.equals("Quarter"))
      coin = new Money (25);
    else if(type.equals("Dime"))
       coin = new Money(10);
    else if(type.equals("Nickel"))
      coin = new Money(5);
    else
      coin = new Money(1);
    for(int i = 1; i <= numCoins; i++){
      this.addCoin(coin);
    }
  }

  /**
  * returns the string representation of the shopper.
  * @return shopper string
  */
  public String toString(){
    return name + " has " + this.getTotalValue() +  " cents and has bought " + this.getPurchases();
  }


}
