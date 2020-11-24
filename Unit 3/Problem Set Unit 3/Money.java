/**
Money (#10 on Pset)
* @author MonicaChan
* @version 1.0
*/
public class Money{
  private int value;
  public Money(int v){
    value = v;
  }

  public int getValue(){return value;}
  public String getName(){
    if(value == 1)
      return "Penny";
    else if(value == 5)
      return "Nickel";
    else if(value == 10)
      return "Dime";
    else if(value == 25)
      return "Quarter";
    else{
      return "Other";
    }
  }

}
