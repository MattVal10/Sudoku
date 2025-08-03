// Matthew Valencia
// CS 143
// HW #3: Sudoku #3 (solve)

// This program will read a file. Fill a 2D array and then fill out the board 
// with either a blank space if the file contains a '.' or a digit that the file has.
// Also checks if a sudoku board is valid or solved using methods.
// Also solves the Sudoku board using recursive backtracking.


public class SudokuSolverEngine {

   public static void main(String[] args) {
      // Here I have called my class `MySudokuBoard` if you named your class
      // differently, modify the line below to use your own class name
      MySudokuBoard board = new MySudokuBoard("/Users/matthewvalencia/Documents/ComputerScience/Java_143_class/week3/HW1SudokuSetup/main/src/very-fast-solve.sdk");
      System.out.println(board);
      System.out.println();

      if (!board.isValid()) {
         System.out.println("board is invalid state and cannot be solved.");
         return;
      }

      if (board.isSolved()) {
         System.out.println("board is already solved.");
         return;
      }

      System.out.print("Solving board...");
      long start = System.currentTimeMillis();
      board.solve();
      long stop = System.currentTimeMillis();
      System.out.printf("SOLVED in %.3f seconds.\n", ((stop-start)/1000.0));
      System.out.println();
      System.out.println(board);
      
   }
}

/* output from the terminal


Solving board...SOLVED in 0.002 seconds.

---------------------
| 5 3 4 6 7 8 9 1 2 |
| 6 7 2 1 9 5 3 4 8 |
| 1 9 8 3 4 2 5 6 7 |
| 8 5 9 7 6 1 4 2 3 |
| 4 2 6 8 5 3 7 9 1 |
| 7 1 3 9 2 4 8 5 6 |
| 9 6 1 5 3 7 2 8 4 |
| 2 8 7 4 1 9 6 3 5 |
| 3 4 5 2 8 6 1 7 9 |
---------------------

matthewvalencia@Matthews-Laptop-2 SudokuWeek4 % clear
matthewvalencia@Matthews-Laptop-2 SudokuWeek4 %  cd /Users/matthewvalencia/Documents/ComputerSci
ence/Java_143_class/week4/SudokuWeek4 ; /usr/bin/env /Library/Java/JavaVirtualMachines/jdk-23.jd
k/Contents/Home/bin/java -XX:+ShowCodeDetailsInExceptionMessages -cp /Users/matthewvalencia/Libr
ary/Application\ Support/Code/User/workspaceStorage/465008a89770b0e7d5d36f6c532eb802/redhat.java
/jdt_ws/SudokuWeek4_3ec4a5e2/bin SudokuSolverEngine 
Initial board
---------------------
|   3 4 6 7 8 9 1 2 |
|   7 2 1 9 5 3 4 8 |
| 1 9 8 3 4 2 5 6 7 |
|     9   6 1 4 2 3 |
|   2 6 8 5 3 7 9 1 |
|   1 3 9 2 4   5 6 |
|   6 1 5 3 7 2 8 4 |
|   8   4 1 9 6 3 5 |
| 3 4 5   8 6 1 7 9 |
---------------------


Solving board...SOLVED in 0.002 seconds.

---------------------
| 5 3 4 6 7 8 9 1 2 |
| 6 7 2 1 9 5 3 4 8 |
| 1 9 8 3 4 2 5 6 7 |
| 8 5 9 7 6 1 4 2 3 |
| 4 2 6 8 5 3 7 9 1 |
| 7 1 3 9 2 4 8 5 6 |
| 9 6 1 5 3 7 2 8 4 |
| 2 8 7 4 1 9 6 3 5 |
| 3 4 5 2 8 6 1 7 9 |
---------------------

 */