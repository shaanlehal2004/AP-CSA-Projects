import java.util.Scanner;

public class TicTacToe{
  public static void main(String args[]){
    System.out.println("Welcome to Tic Tac Toe");
    System.out.println("Player 1 will be playing with character X");
    System.out.println("Player 2 will be playing with character O");

    Scanner keyboard = new Scanner(System.in);
    System.out.println("What size should the grid be?");
    int gridSize = keyboard.nextInt();
    keyboard.nextLine();
    String[][] board = create2D(gridSize);
    //this boolean will be used as a condition for the running of the game.
    boolean win = false;
    //the cell player 1 chooses.
    String play1Cell;
    //the cell player 2 chooses.
    String play2Cell;
    //boolean used as a holder for the condition of whether the input is valid or not.
    boolean valid = false;
    //will determine which player goes first.
    int turn = (int)(Math.random() * (2)) + 1;


    while(win == false){
      //if it's player 1's turn.
      if(turn == 1){
      //have to reset valid after every turn, otherwise the input will never be checked again.
        valid = false;
        printNiceGrid(board);
        System.out.println("Player 1, choose a cell");
        play1Cell = keyboard.nextLine();

        //checks input
        while(valid == false){
          valid = checkInput(board, play1Cell);
          if(valid == false)
            play1Cell = keyboard.nextLine();
          else{
            placeCell(board, play1Cell, "X");
            win = checkWin(board);
            }
          }

          if(win){
            System.out.println("Player 1 wins!");
            printNiceGrid(board);
            break;
          }
          else if(checkTie(board)){
           System.out.println("It's a tie!");
           break;

         }
          turn = 2;
      }

      //if it's player 2's turn.
      if(turn == 2){
        valid = false;
        printNiceGrid(board);
        System.out.println("Player 2, choose a cell");
        play2Cell = keyboard.nextLine();
        while(valid == false){
          valid = checkInput(board, play2Cell);
          if(valid == false)
            play2Cell = keyboard.nextLine();
          else{
            placeCell(board, play2Cell, "O");
            win = checkWin(board);
          }
        }
        if(win){
          System.out.println("Player 2 wins!");
          printNiceGrid(board);
        }
        else if(checkTie(board)){
          System.out.println("It's a tie!");
          break;
        }
        turn = 1;

        }
     }
  }


  /** This function creates the board.
  * @param size the desired grid length and width.
  * @return the string board (2d array)
  */
  public static String[][] create2D(int size){
    String[][] newArr = new String[size][size];
    int arrNum = 1;
    //this loop labels all the cells of the board.
    for(int r = 0; r< newArr.length; r++){
      for(int c = 0; c<newArr[r].length; c++){
        newArr[r][c] = "" + arrNum;
        arrNum++;
      }
    }
    return newArr;
  }

  /** This function prints the grid in a neat format. ((I admit this is not my function))
  * @param grid is the grid to print.
  */
  public static void printNiceGrid(String[][] grid){
    // Find the maximum size when printed for all the elements in the array
    int maxSize = 0;
    for(int r = 0; r < grid.length; r++){
      for (int c = 0; c < grid[r].length; c++){
        int size = grid[r][c].length();
        if (size > maxSize)
          maxSize = size;
      }
    }
    // Print the array
    for (int r = 0; r < grid.length; r++)
    {
      // Print the line above the row
      for (int c = 0; c < grid[r].length; c++)
      {
        System.out.print("+");
        for(int i = 0; i < maxSize; i++)
          System.out.print("-");
      }
      System.out.println("+");
      System.out.print("|");
      // Print all entries for this row
      for (int c = 0; c < grid[r].length; c++)
      {
        // Determine the size of the current element
        int size = grid[r][c].length();
        for(int i = 0; i < maxSize - size; i++)
          System.out.print(" ");
        System.out.print(grid[r][c] + "|");
      }
      System.out.println();
    }
    // Print last row below the array
    for (int c = 0; c < grid[0].length; c++)
    {
      System.out.print("+");
      for(int i = 0; i < maxSize; i++)
        System.out.print("-");
    }
    System.out.println("+");
  }

  /**
  * This function checks the input if it's valid or not.
  * @param grid the tic tac toe board
  * @param location the cell number that the user put
  * @return boolean: true if the input is valid, false if not.
  */
  public static boolean checkInput(String[][] grid, String location){
    //general strategy: iterate through all the cells, and if there's a cell which matches the input, then the input is valid.
      for(int r = 0; r<grid.length; r++){
        for(int c = 0; c<grid[r].length; c++){
          if(grid[r][c].equals(location))
            return true;

        }
      }
      System.out.println("Sorry, invalid input");
      return false;
  }

/**
This function places either an X or O on the designated user input cell number.
* @param grid the tictactoe board
* @param location the cell number the user chose
* @param input either "X" (player 1) or "O" (player 2)
* @return the tic tac toe board
*/
  public static String[][] placeCell(String[][] grid, String location, String input){
    for(int r = 0; r<grid.length; r++){
      for(int c = 0; c<grid[r].length; c++){
        if(grid[r][c].equals(location))
          grid[r][c] = input;
      }
    }
    return grid;
  }

/**
This function checks to see if the previous move made the user win the game.
* @param grid the tic tac toe board
* @return a boolean: false if no win yet, true if win detected.
*/
  public static boolean checkWin(String[][] grid){
    //since the grid is a square, the number of rows and columns will be the same, therefore we can evaluate the column and row with the same variable in the for loop.
    for(int i = 0; i<grid.length; i++){
      if(columnEqual(grid, i)){
        System.out.println("Detected a column!");
        return true;
      }
      if(rowEqual(grid, i)){
        System.out.println("Detected a row!");
        return true;
      }
      if(diagonal(grid, 1)){
        System.out.println("Detected a diagonal!");
        return true;
      }
      if(diagonal(grid, 2)){
        System.out.println("Detected a diagonal!");
        return true;
      }
    }
    return false;

  }

/**
This function checks for all X's or all O's in a column.
* @param grid the tic tac toe board
* @param c which column is being tested.
* @return true if all elements in the column are equal, false otherwise.
*/
  public static boolean columnEqual(String[][] grid, int c) {
        String x = grid[0][c];
        for (int r = 0; r < grid.length; r++) {
            if(!grid[r][c].equals(x))
              return false;
        }
        return true;
    }

/**
This function checks for all X's or all O's in a row
* @param grid the tic tac toe board
* @param r which row is being tested.
* @return true if all elements in the row are equal, false otherwise.
*/
  public static boolean rowEqual(String[][] grid, int r){
    String x = grid[r][0];
    for(int c = 0; c<grid[r].length; c++){
      if(!grid[r][c].equals(x))
        return false;
    }
    return true;
  }

/**
This function checks for all X's or all O's in a diagonal
* @param grid the tic tac toe board
* @param d is which diagonal is being evaluated, 1 if it's the diagonal starting at [0][0], else it's the other diagonal starting at the bottom left corner.
* @return true if the diagonal is all the same, false otherwise.
*/
  public static boolean diagonal(String[][] grid, int d){
    if(d == 1){
      String x = grid[0][0];
      //the cells in a diagonal are always going to be offset by 1 column and 1 row from the previous cell.
      for(int i = 0; i<grid.length; i++){
        if(!grid[i][i].equals(x))
          return false;
      }
      return true;
    }
    else{
      String y= grid[grid.length-1][0];
      for(int i = grid.length-1, c = 0; i >= 0; i--, c++){
        if(!grid[i][c].equals(y))
          return false;
      }
      return true;
    }
  }

/**
This function checks for if all the elements of the board are taken up, hence a tie.
* @param grid the tic tac toe board
* @return true if there's a tie, false otherwise.
*/
  public static boolean checkTie(String[][] grid){
    for(int r = 0; r < grid.length; r++){
      for(int c = 0; c < grid[r].length; c++){
        if(grid[r][c].equals("X") == false && grid[r][c].equals("O") == false){
          return false;
        }
      }
    }
    return true;
  }
}
