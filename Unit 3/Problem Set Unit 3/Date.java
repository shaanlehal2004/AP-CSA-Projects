/**
Date #4 on pset
* @author MonicaChan
* @version 1.0
*/
public class Date{
  private int year;
  private int month;
  private int day;
  private static String[] strMonths = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
  private static String[] strDays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
  private static int[] endDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

  public Date(int y, int m, int d){
    year = y;
    month = m;
    day = d;
  }

  //accessors
  public int getYear(){return year;}
  public int getMonth(){return month;}
  public int getDay(){return day;}

  /**
  * Sets the date, if the inputs are valid
  * @param y is the new year to set to
  * @param m is the month to set to
  * @param d is the date to set to
  */
  public void setDate(int y, int m, int d){
    boolean validDate = isValidDate(y, m, d);
    if(validDate == true){
      year = y;
      month = m;
      day = d;
    }
  }

  /**
  * gives the string representation of the date in format (weekday, day, month, year)
  *@return the string date.
  */
  public String toString(){
    return this.getDayOfWeek() + " " + day + " " + strMonths[month-1] + " " + year;
  }

  /**
  * Returns the next day in type Date.
  * @return the next date
  */
  public Date nextDay(){
    int nextYear =  year;
    int nextDay = day;
    int nextMonth = month;
    if(month==12 && day == 31){
      nextYear += 1;
      nextMonth = 1;
      nextDay = 1;
    }
    else if(day == endDays[month-1]){
      nextDay = 1;
      nextMonth += 1;
    }
    else if(isLeapYear(this.getYear()) && month == 2 && day == 29){
      nextMonth += 1;
      nextDay = 1;
    }
    else{
      nextDay++;
    }
    Date returnDate = new Date(nextYear, nextMonth, nextDay);
    return returnDate;
  }

  /**
  *returns the day of the week for the given date. Below is an algorithm to
  determine the day of the day of the week.
  * @return the day of the week
  */
  public String getDayOfWeek(){
    int y = year;
    int m = month;
    if(m == 1 || m == 2)
      y -= 1;
    y %= 100;
    int c = y/100;
    m -=  2;

    if(m <= 0){
      m+= 12;
    }

    int w = day + (int)(2.6 * m - .2) + y + y/4 + c/4 -2 * c;

    while(w<0){
      w += 7;
    }
      w %=7;
    return strDays[w];

  }
  /**
  * returns whether or not a year is a leap year.
  * @param y the year to test.
  * @return a boolean: true if the input is a leap year, false otherwise.
  */
  public static boolean isLeapYear(int y){
    if(y % 400 == 0)
      return true;
    if(y % 100 == 0){
      return false;
    }
    else if(y % 4 != 0){
      return false;
    }

    else{
      return true;
    }
  }
/** returns a boolean to indicate that the given date is valid, the year should
be between 1 and 9999, the month should be between 1 and 12, and the day should
be between 1 and 28/29/30/31 depending on the month and whether it is a leap year.
* @param y is the year
* @param m is the month
* @param d is the date
* @return boolean: true if the date is valid, false otherwise.
*/
  public static boolean isValidDate(int y, int m, int d){
    boolean yValid = false;
    boolean mValid = false;
    boolean dValid = false;
    if(y > 1 && y <9999){
      yValid = true;
    }

    if(m > 0 && m < 13){
      mValid = true;
    }
    if(yValid == false || mValid == false)
      return false;

    boolean leapYear = isLeapYear(y);
    if(leapYear && m == 2){
        if(d > 0 && d < 30)
          dValid = true;
    }
    if(d > 0 && d <= endDays[m-1])
      dValid = true;

    if(yValid && mValid && dValid)
      return true;

    return false;
  }




}
