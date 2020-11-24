/**
SavingsAccount (#7 on Pset)
* @author MonicaChan
* @version 1.0
*/
public class SavingsAccount{
  private static double annualInterestRate;
  private double savingsBalance;

  public SavingsAccount(){
    savingsBalance = 0;
    annualInterestRate = .1;
  }
  public SavingsAccount(double b){
    savingsBalance = b;
    annualInterestRate = .2;
  }

  public double getSavingsBalance(){return savingsBalance;}

  /**
  *Updates the savings balance by adding the monthly interest. The monthly
  interest is calculated by multiplying the savings balance by the annual
  interest rate, divided by 12. It should be returned by the method.
  * @return the interest gained.
  */
  public double calculateMonthlyInterest(){
    double interest = (savingsBalance * annualInterestRate)/12;
    savingsBalance += interest;
    return interest;
  }

  /**
  *sets the annual interest rate to a new value.
  *@param val is the new interest rate.
  */
  public static void modifyInterestRate(double val){
    annualInterestRate = val;

  }

}
