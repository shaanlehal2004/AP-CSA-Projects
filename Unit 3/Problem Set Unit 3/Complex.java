/**
Complex (#1 on Pset)
* @author MonicaChan
* @version 1.0
*/
public class Complex{
  private double real;
  private double imag;

  public Complex(){
    real = 1;
    imag = 0;
  }
  public Complex(double r, double i){
    real = r;
    imag = i;
  }

  /**
  * This function returns the modulus of the complex number.
  * @return mod the modulus of the complex number.
  */
  public double modulus(){
    double mod = Math.sqrt(Math.pow(real, 2)+ Math.pow(imag, 2));
    return mod;
  }

  /**
  * This function calculates the angle of the complex number.
  * @return angle the angle of the complex the
  */
  public double angle(){
    double angle = Math.atan2(imag,real);
    return angle;
  }

  /**
  *toString function for complex numbers in a+bi form.
  * @return the string representation of the complex number. 
  */
  public String toString(){
    return "" + real + " + "+ imag + "i";

  }




}
