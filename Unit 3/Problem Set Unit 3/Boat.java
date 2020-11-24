/**
Boat (#8 on Pset)
* @author MonicaChan
* @version 1.0
*/
public class Boat extends Sea{

  public Boat(int t, double p, boolean fe, int lj, int lb, int perBoat){
    super(t, p, fe, lj, lb, perBoat);
  }
  public Boat(int t, double p){
    super(t, p, false, 0, 0, 0);
  }

}
