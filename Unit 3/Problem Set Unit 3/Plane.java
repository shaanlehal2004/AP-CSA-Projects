/**
Plane (#8 on Pset)
* @author MonicaChan
* @version 1.0
*/
public class Plane extends Air{

  public Plane(int t, int p, boolean fe, int lj, int lb, int c){
    super(t, p, fe, lj,lb, c);
  }
  public Plane(int t, int p){
    super(t, p, false, 0, 0, 0);
  }


}
