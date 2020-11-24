/**
Qubit (#2 on Pset)
* @author MonicaChan
* @version 1.0
*/
public class Qubit{
  public Complex down;
  public Complex up;
  public Qubit(){
    down = new Complex(0,0);
    up = new Complex(1,0);
  }
  public Qubit(Complex a, Complex b){
    up = a;
    down = b;
  }

  /**
  * returns a String, “up”, “down”, or “invalid state”. The state is valid if
  modulus(up)2 + modulus(down)2 = 1. The output is “up” if a random number falls
  within the probability of outcome modulus(up)2. Otherwise, the output is “down”.
  * @return the state of the quantum bit
  */
  public String measure(){
    String state = "";
    double rand = Math.random();
    if(Math.abs(Math.pow(up.modulus(), 2) + Math.pow(down.modulus(), 2))-1 > 0.00001)
      state = "invalid state";
    else if(rand >= Math.pow(up.modulus(),2)){
      state = "down";
    }
    else if(rand < Math.pow(up.modulus(), 2)){
      state = "up";
    }
    return state;
  }

  /**
  * returns the String representation of what the quantum bit is.
  * @return quantum bit in string form.
  */
  public String toString(){
    return "up: " + up.toString() + " down:" + down.toString();
  }
}
