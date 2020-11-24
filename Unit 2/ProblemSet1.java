import java.util.ArrayList;


public class ProblemSet1{

  /**
   This function takes in a positive integer n, and returns an array whose values
   increment from 1 to n, then decrement back to 1. ie { 1, 2, ... n... 2, 1}

   General strategy: break up into two for loops, the first one incrementing,
   second one decrementing.
   * @param n is the number to increment up to.
   * @return integer array with the wedge.
  */
  public static int[] createWedge(int n){
    int increment = 1;
    int[] wedge = new int[(2*n)-1];

    //this for loop increments the array elements {1, 2, 3...}.
    for(int i = 0; i < n; i++){
      wedge[i] = increment;
      increment++;
    }
    increment = n-1;
    //this for loops decrements the array elements {...3,2,1}.
    for(int j = n; j < wedge.length; j++){
      wedge[j] = increment;
      increment--;
    }
    return wedge;
  }

  /**
  This function takes in a positive integer n greater than or equal to 2, and
  returns an integer array with n numbers in the fibonacci sequence.

  General strategy: make a for loop that sums up the previous two indeces, start at index = 2.
  * @param n is the desired number of fibonacci sequence members.
  * @return integer array with the fibonacci sequence.
  */
  public static int[] fibArray(int n){
    int[] fib = new int[n];
    //first two numbers of the fibonacci sequence are 1 and 1.
    fib[0] = 1;
    fib[1] = 1;
    //thi for loop sums the previous two elements and makes that sum the next element.
    for(int i = 2; i< fib.length; i++){
      fib[i] = fib[i-2] + fib[i-1];
    }
    return fib;
  }

  /**
  This function takes in the median to test "m" and a double array to test.
  A median is a median if the number of elements of the array that are less than the median
  are equal to the number of elements of the array that are greater than the median.

  General strategy: make a for loop that goes through the whole double array,
  and if the array element is greater than the parameter median, increment a value greater than.
  otherwise, increment a value called lessThan. If the two values after the loop are the same,
  then it's a median.
  * @param m is the median to test.
  * @param arr is the double array.
  * @return a boolean: true if m is a median, false if not.
  */
  public static boolean isMedian(double m, double[] arr){
    //all the numbers less than the median.
    int lessThan = 0;
    //all the numbers greater than the median.
    int greaterThan = 0;
    for(int i = 0; i< arr.length; i++){
      if(arr[i] > m)
        greaterThan++;

      else if(arr[i] < m)
        lessThan++;
    }

    if(lessThan == greaterThan)
      return true;

    return false;
  }

  /**
  This function rotates the elements of an array one index to the left.
  If it's the first element, that element will get wrapped around to the end.

  General strategy: run a for loop that iterates through the whole integer array,
  if it's the first element of the array, the new index will be the last index of the array.
  Otherwise, it is just the current index minus one.
  After these if statements, assign the element to its new index of a new array. Then reassign
  all the values back to the original array.
  * @param a the integer array that is getting shifted.
  */
  public static void rotateLeft(int[] a){
    //newIndex will be the new index of the element.
    int newIndex;
    int[] newA = new int[a.length];
    for(int i = 0; i< a.length; i++){
      //checks to see if the element being checked is the first one of the array.
      if(i == 0)
        newIndex = a.length-1;
      else
        newIndex = i-1;
      //assign the element a new index into the new array.
      newA[newIndex] = a[i];
    }

    //copy the new array back into the old one.
    for(int j = 0; j< newA.length; j++)
      a[j] = newA[j];
  }

  /**
  This function rotates the elements of an array one index to the right.
  If it is the last element, that element will get wrapped around to the front of the array.

  General strategy: Similar to rotateLeft, run a for loop that iterates through the whole integer array.
  If it is the last element, the new index will be 0. Otherwise, it is the current index plus one.
  After the if statements, assign the element to its new index of a new array. Then reassign
  all the values back to the original array.
  * @param a is the integer array that is getting shifted.
  */
  public static void rotateRight(int[] a){
    int newIndex;
    int[] newA = new int[a.length];
    for(int i = 0; i< a.length; i++){
      //checks to see if the element being checked is the last one of the array.
      if(i == a.length-1)
        newIndex = 0;
      else
        newIndex = i+1;
      //assign the element a new index into the new array.
      newA[newIndex] = a[i];
    }

    //copy the new array back into the old one.
    for(int j = 0; j< newA.length; j++)
      a[j] = newA[j];
  }

  /**
  This function rotates the elements of integer array a by d places. If d is positive
  rotate right, if d is negative rotate left.

  General strategy: If d is positive, create a while loop and decrement d until it equals 0,
  and in that loop call the rotateRight function. If d is negative, do the saem thing except
  call rotateLeft.
  * @param a is an integer array that is to be shifted.
  * @param d is the integer number of places to shift the array.
  */
  public static void rotate(int[] a, int d){
    //Take the absolute value of the int d becuase I use temp as a variable to decrement as a condition for a while loop.
    int temp = Math.abs(d);
    //positive d calls rotateRight
    if(d > 0){
      while(temp > 0){
        rotateRight(a);
        temp--;
      }
    }
    //negative d calls rotateLeft
    else if(d < 0){
      while(temp > 0){
        rotateLeft(a);
        temp--;
      }
    }

  }

  /**
  This function takes the values in an integer array list and puts them into a regular array.

  General strategy: iterate through the array list and copy the elements into an integer array relying  on
  autounboxing.
  * @param a is an integer array list to be converted.
  * @return an integer array with the elements of the array list.
  */
  public static int[] convert(ArrayList<Integer> a){
    int[] returnArray =  new int[a.size()];
    for(int i = 0; i<a.size(); i++){
      returnArray[i] = a.get(i);
    }
    return returnArray;
  }

  /**
  This function checks to see if all the elements of a string array list are the same,
  ignoring whether they have the same case.

  General strategy: first check if the two array lists are the same length, if not, they definitely
  can't be the same. If not, run a for loop that iterates through both array lists
  and uses .toLowerCase() to evaluate whether the two elements are the same. Return false if the element doesn't match up.

  * @param a is the first string array list.
  * @param b is the second string array list.

  * @return true if they are the same, false otherwise.
  */
  public static boolean equalsIgnoreCase(ArrayList<String> a, ArrayList<String> b){
    //checks to see if the array lists are the same size.
    if(a.size() != b.size()){
      return false;
    }
    //the string of the first array.
    String one;
    //the string of the second array.
    String two;

    for(int i = 0; i< a.size(); i++){
      one = a.get(i).toLowerCase();
      two = b.get(i).toLowerCase();
      if(!one.equals(two)){
        return false;
      }
    }
    return true;
  }

  /**
  This function takes in integer array a and returns an array list that contains the
  5 greatest integers of array a.

  General strategy: first start off by adding some elements into the array list so it's not empty.
  Then use nested for loops to find the largest value of the array, add it to the array list, Then
  make that value in the original array 0 so it gets ignored the next time the loop runs.
  * @param a the integer array to find the top 5 numbers.
  * @return an integer array list with the 5 greatest numbers of a.
  */
  public static ArrayList<Integer> top5(int[] a){
    ArrayList<Integer> returnArray = new ArrayList<Integer>(5);

    //add elements into the array list so it's not empty.
    for(int m = 0; m<5; m++){
      returnArray.add(a[m]);
    }

    //largest will store the largest element of the array.
    int largest = a[0];
    //index will store the index of the largest element.
    int index = 0;

    for(int i = 0; i < 5; i++){
      for(int j = 0; j < a.length; j++){
        //this if statement will assign the largest element to largest and its index to index.
        if(largest < a[j]){
          largest = a[j];
          index = j;
        }
      }

      //put the largest integer into the return array.
      returnArray.set(i, largest);

      //then make the largest value in the original array 0 so it gets ignored the next time the loop runs. .
      a[index] = 0;
      largest = 0;

    }
    return returnArray;
  }


  /**
  This function retrieves the lowest ascii value string in a string array list.

  General strategy: store the smallest string in a variable call smallest, use
  compareTo on the elements of the array list to get a positive or negative number. If it is
  positive when compared to the variable smallest, then that element has a higher ascii value.
  If the number is negative when compared to variable smallest, then that element has a lower ascii
  value, so store that string into the smallest variable.
  * @param array is the array list where we are trying to find the lowest ascii string of.
  * @return the lowest ascii value string.
  */
  public static String getFirst(ArrayList<String> array){
    String smallest = array.get(0);

    for(int i = 0; i < array.size(); i++){
        //if x is greater than 0, it is bigger than the smallest string, otherwise it is smaller than the smallest string.
        int x = array.get(i).compareTo(smallest);
        if(x < 0)
          smallest = array.get(i);
    }
    return smallest;
  }

  /**
  This function replaces all the digits in a character array with 'z'.

  General strategy: use the ascii values of the characters to determine if it is a digit.
  If it is, replace that element of the array with a 'z'.
  * @param a is the character array which we are editing.
  */
  public static void replace(char[][] a){
    for(int r = 0; r < a.length; r++){
      for(int c = 0; c < a[r].length; c++){
        //48-57 is integers ascii inclusive
        if((int)a[r][c] > 47 && (int)a[r][c] < 58)
          a[r][c] = 'z';
      }
    }
  }

  /**
  This function multiplies two matrices.

  General strategy: use 3 nested loops to navigate through the two 2d arrays.
  Then, add to the product 2d array the product of the cells of the original 2 arrays.
  Only move to the next cell of the product 2d array after all the elements of one row of the first matrix
  have been multiplied by all the elmenets of the corresponding column of the second one.
  * @param a the first matrix.
  * @param b the second matrix.
  * @return the product matrix.
  */
  public static int[][] multiply(int[][] a, int[][] b){
    int[][] returnArray = new int[a.length][b[0].length];

    for(int x = 0; x < a.length; x++){
      for(int y = 0; y < b[0].length; y++){
        for (int k = 0; k < a[x].length; k++) {
          //x and y are used together to navigate the product array, x & k for the first matrix, then k & y for the second.
            returnArray[x][y] += a[x][k] * b[k][y];
        }
      }
    }
    return returnArray;
  }


//These next two functions are used for the runner.
  public static void printIntArray(int[] ar)
 {
   System.out.print(" { ");
   for(int i = 0;i < ar.length; i++)
   {
     if (i != ar.length - 1)
       System.out.print(ar[i] + ", ");
     else
       System.out.print(ar[i]);
   }
   System.out.println(" } ");
 }


 public static void printInt2DArray(int[][] ar)
 {
   for(int r = 0;r  < ar.length; r++)
   {
     for(int c = 0; c<ar[r].length; c++){
       if (c != ar[r].length - 1)
         System.out.print(ar[r][c] + ", ");
       else
         System.out.print(ar[r][c]);
     }
     System.out.println();

   }
 }

 public static void printChar2DArray(char[][] ar)
 {
   for(int r = 0;r  < ar.length; r++)
   {
     for(int c = 0; c<ar[r].length; c++){
       if (c != ar[r].length - 1)
         System.out.print(ar[r][c] + ", ");
       else
         System.out.print(ar[r][c]);
     }
     System.out.println();

   }
 }

}
