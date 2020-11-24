public class PracticeQuiz{
  public static void main(String[] args){
    int[][] arr = { {1,2,3}, {3,4} };
    printColMajor(arr);
  }
  public static void printColMajor(int[][] arr){
    int length;
    for(int r = 0; r < arr.length; r++){
      length = arr[0].length;
      for(int c = 0; c < length; c++){
        if(arr[r].length < length)
          length = arr[r].length;
        else
          System.out.print(arr[c][r] + ", ");
      }
    }
    System.out.println();
  }
}
