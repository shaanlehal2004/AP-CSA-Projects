/**
Haiku (#6 on Pset)
* @author MonicaChan
* @version 1.0
*/
public class Haiku extends Poem{
  private int numL;
  public Haiku(){
    numL = 3;
  }
  public int numLines(){
    return numL;
  }
  public int getSyllables(int k){
    if(k == 1 || k == 3){
      return 5;
    }
    else{
      return 7;
    }
  }
}
