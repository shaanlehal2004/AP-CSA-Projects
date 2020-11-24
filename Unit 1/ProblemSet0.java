/**
* @author MonicaChan
* @version 1.0
*/

public class ProblemSet0{

  /**
  This function takes in a base 10 integer and returns the binary
  form of it.
  * @param i integer which is in base 10 to convert to binary.
  * @return the binary number in string form.
  Response to question: returning an integer would limit us because
  the conversion of bases also leads to the placement of ones, tens, and hundreds
  being different from ones, twos, and fours. It is much more simple to use a
  string where you can just add onto the end of the string. For instance, a
  number in base 10 that is three digits might be 8 digits long in binary.
  */
  public static String toBinary(int i){
    //general strategy: using the method where I keep dividing the quotient by two
    //and stealing the remainder to convert to binary.
    int remainder = i % 2;
    int quotient = i / 2;

    //once the function reaches the end of the number, it will stop.
    if(quotient == 0)
      if(remainder == 1)
        return "" + remainder;
      else{
        return "";
      }

    //otherwise, it will continue to run recursively, calling itself
    //on the quotient and stealing the remainder.
    else{
      //using recursive methods
      String returnString = "" + remainder;
      return toBinary(quotient) + returnString;
    }
}

/**
This function takes in a parameter to represent the number of sides
of a dice, and simulates "rolling" the dice and returns a random
side.
* @param n integer which represents number of sides of the dice.
* @return the integer that represents the rolled side of the dice.
*/
  public static int rollDie(int n){
    //generate a random number between 1 and the number of sides of the dice.
    int randomInt = (int)(Math.random() * n) + 1;
    return randomInt;
  }

/**
This function prints out a multiples table that has the number of
rows which the function takes in as an argument. Table looks like a
right triangle.
* @param o integer that represents the number of rows for the multiples table.
*/
  public static void multiples(int o){
    /*general strategy: iteravely print by row. Make so that the
    difference between each number in the same row is the same,
    but the difference will increase by one to the next row.
    */
    for(int i = 1; i <= o; i++){
      String numberLine = "";

      //this second for loop is so that each individual row increments by 1.
      for(int m=1; m <= i; m++){
        //m*i represents the multiples, the difference between each
        //number in the same row will be the same, but the difference will increase by one to the next row.
        System.out.print(m*i + "\t");
      }
      System.out.println();
  }
}


/**
This function swaps the tens and one place of an integer.
* @param a integer whose tens and ones digits will swap.
* @return the swapped tens and ones place outcome.
*/
  public static int swap(int a){
    /*
    General strategy: isolate ones and tens using modulo, subtract
    the sum of the tens and ones from the oritinal value, divide the tens place by ten,
    multiply the ones place by ten, add them back together into the difference.
    */
    //isolating the ones and tens digit.
    int ones = a % 10;
    int temp = a/10;
    int tens = (temp % 10) * 10;
    //subtracting them from the original number
    int difference = tens + ones;
    a -= difference;
    //changing the ones place to the tens place
    ones = ones * 10;
    //changing the tens place to the ones.
    tens = tens / 10;
    difference = tens + ones;
    //adding back the swap.
    a += difference;
    return a;

  }

  /*
  This function prints the three possible xor equations.
  */
  public static void xor(){
    /*
    Xor is going to be only true if a and b are different.
    */
    System.out.println("a && !b || !a && b");
    System.out.println("!((a && !b) && (!a && b))");
    System.out.println("a != b");

  }

  /**
  This function takes in the number of stars to be printed and
  prints them all on one line.
  * @param n number of stars to be printed.
  */
  public static void printStars(int n){
    /*
    General strategy is to use a single for loop to print one star each iteration.
    */
    for(int i = 1; i <= n; i++){
      System.out.print("*");
    }
    System.out.println();
  }

  /**
  This function prints a triangle of stars with given row numbers
  using the printStars function.
  * @param n number of rows for the star triangle.
  */
  public static void printTriangle(int n){
    //general strategy is to iterate and call the prinStar function for that row number.
    for(int i = 1; i <= n; i++){
      printStars(i);
    }
  }


  /**
  This function prints a triangle of stars with n rows recursively.
  * @param n represents the number of rows the triangle should have.
  */
  public static void printRecursive(int n){
    if(n > 0){
        //the code will call its function first, then work its way up from the bottom.
        printRecursive(n-1);
        //the rest works kind of the same as the other triangle printing strategies.
        for(int i = n; i >= 1; i--){
          System.out.print("*");
        }
        System.out.println();
    }
    else
      System.out.println();

  }

  /**
  This function prints an upside down triangle of stars with n rows recursively.
  * @param n represents the number of rows the triangle should have.
  */
  public static void printRecursive2 (int n){
    //similar to the last function, except code works its way from the peak to the base.
    if(n > 0){
      for(int i = 0; i < n; i++)
        System.out.print("*");
      System.out.println();
      printRecursive2(n-1);
    }
  }

  /**
  This function adds the digits of an integer called number.
  * @param number the integer whose digits will be added.
  * @return the sum of the digits.
  */
  public static int sumDigits(int number){
    /*
    General strategy: find the number of digits, create an array with length
    of the number of digits, the individually append the digits to that array,
    then use a for loop to add together the values of the integers.
    */
    int multiple = 1;
    int digits = 0;
    //this while loop counts the number of digits.
    while(number / multiple != 0){
      digits += 1;
      multiple *= 10;
    }
    //intializing an array to be digits long.
    int[] digitArr = new int[digits];
    int counter = 0;

    //this while loop will add the digits individually to the array.
    while(number > 0){
      digitArr[counter] = number % 10;
      number /= 10;
      counter += 1;
    }
    int sum = 0;

    //adds digits together
    for(int m = 0; m < digitArr.length; m++){
      sum += digitArr[m];
    }
    return sum;
  }

  /**
  This function uses sumDigits to determine if a number is divisible by 3 without using modulo.
  * @param n is the number which is being checked for divisibility.
  * @return true if n is divisible by 3, false if it is not.
  */
  public static boolean isDivisible(int n){
    /*
    Use sumDigits, run function recursively by just subtracting three from the
    argument each time. once the argument reaches below three, it can be determined
    if it is a multiple of 3 or not.
    */
    int sumDigits = sumDigits(n);
    if(sumDigits < 3){
      if(sumDigits == 0)
        return true;
      else
        return false;
    }
    else
      return isDivisible(n-3);
  }

  /**
  This function prints a diamond of stars with 2n-1 rows.
  * @param n the number of unique, different rows there should be.
  */
  public static void printMoreStars(int n){
    /*
    General strategy: There are going to be 2n-1 rows.
    Use one for loop to print the top half, another to print the bottom half.
    In the top half, keep subtracting spaces and adding stars.
    In the bottom half, keep adding spaces and removing stars.
    */
  //spaces is going to be number of rows/2 on each side of the stars.
  int rows = 2*n - 1;
  String spaces = "";
  String stars = "*";
  for(int i = 0; i < rows/2; i++){
    spaces += " ";
  }
  //this for loop is for the top half of the diamond.
  for(int j = 0; j < rows/2; j++){
    System.out.println(spaces + stars + spaces);
    //the number of stars in each row will differ by two.
    stars += "**";
    //there will be one less space on each side of the stars for each row.
    spaces = spaces.substring(1);
  }
  //this for loop is for the bottom half of the diamond.
  for(int k = rows/2; k >= 0; k--){
    System.out.println(spaces + stars + spaces);
    //once the length of stars is less than three, it will be one.
    //that is why i have the if statement for stars.length()
    if(stars.length() >= 3){
      stars = stars.substring(2);
      spaces += " ";
    }
  }
}

/**
This function prints the coin combination for the least number of coins for a cent amount.
* @param amount the amount of cents that needs to be combined into coins.
*/
public static void leastCoins(int amount){
  //general strategy: use the biggest coins possible first
  //for the amount value, then use smaller coins.
  int quarterAmount = amount / 25;
  amount = amount % 25;
  int dimeAmount = amount / 10;
  amount = amount % 10;
  int nickelAmount = amount / 5;
  amount = amount % 5;
  int pennyAmount = amount;
  String printString = "";

  String quarter = quarterAmount + " quarters, ";
  String dime = dimeAmount + " dimes, ";
  String nickel = nickelAmount + " nickels, ";
  String penny = " and " + pennyAmount + " pennies";
  printString = quarter + dime + nickel + penny;
  System.out.println(printString);
}

/**
This function prints all the possible coin combinations for a given cent amount.
* @param cents the cent amount which will be combined into coins.
*/
public static void coins(int cents){
  //general strategy: using nested for loops, iterate all possibilities.
  int possibilities = 0;
  //quarter loop: q, d, and n will be in cents values, not number of each.
  for(int q = 0; q <= cents; q+=25){
    //dime loop; i subtract the quarter value from the cents.
    for(int d = 0; d <= cents-q; d+=10){
      //nickel loop; subtract the dime and quarter values from cents.
      for(int n = 0; n <= cents-q-d; n+=5){
        int p = cents - q - d - n;
        //this if statement accounts for when there is negative cents.
        if(p < 0){
          p = 0;
        }
        System.out.println(q/25 + " quarters, " + d/10 + " dimes, " + n/5 + " nickels, " + p + " pennies." );
        possibilities += 1;
      }
    }
  }
  System.out.println("Number of combinations: " + possibilities);
}
}
