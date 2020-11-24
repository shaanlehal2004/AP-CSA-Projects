public class test{


  public static void main(String args[]){
    int[][] newArr = create2D(5);
    printIntArray(newArr);
  }
  public static int[][] create2D_4x4(){
    int[][] newArr = new int[4][4];
    int arrNum = 1;
    for(int r = 0; r< newArr.length; r++){
      for(int c = 0; c<newArr[r].length; c++){
        newArr[r][c] = arrNum;
        arrNum++;
      }
    }
    return newArr;
  }

  public static void printIntArray(int[][] ar)
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

  public static int[][] create2D(int size){
    int[][] newArr = new int[size][size];
    int arrNum = 1;
    for(int r = 0; r< newArr.length; r++){
      for(int c = 0; c<newArr[r].length; c++){
        newArr[r][c] = arrNum;
        arrNum++;
      }
    }
    return newArr;
  }

  public static void print2Darray(int[][] ar){
    int digitNum = 0;
    String border = "+--";
    for(int c = 0; c<ar[ar.length][c].length; c++){
      digitNum += Math.log10(ar[ar.length][c])
    }

  }

}
