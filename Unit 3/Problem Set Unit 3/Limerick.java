/**
Limerick (#6 on Pset)
* @author MonicaChan
* @version 1.0
*/
public class Limerick extends Poem{
  private int numL;
  public Limerick(){
    numL = 5;
  }
  public int numLines(){
    return numL;
  }
  public int getSyllables(int k){
    if(k == 1 || k == 2 || k == 5){
      return 9;
    }
    else if(k == 3 || k == 4){
      return 6;
    }
    return 0;
  }

}
