// Matthew Valencia
// CS 143 
// HW # 1: Sudoku #1 (Board Setup)

// This program will read a file. Fill a 2D array and then fill out the board 
// with either a blank space if the file contains a '.' or a digit that the file has


public class PlaySudoku {

    // pre: none
    // post: creates a SudokuBoard from a file, then prints the board to the console
    public static void main(String[] args) throws Exception {
        MySudokuBoard board = new MySudokuBoard("/Users/matthewvalencia/Documents/ComputerScience /Java_143_class/week3/HW1SudokuSetup/main/src/data1-1-1.sdk");
        System.out.println(board);
    }
}

/* Output from console
I used visual Studio code for this project

File output

---------------------
| 2     1   5     3 |
|   5 4       7 1   |
|   1   2   3   8   |
| 6   2 8   7 3   4 |
|                   |
| 1   5 3   9 8   6 |
|   2   7   1   6   |
|   8 1       2 4   |
| 7     4   2     1 |
---------------------

 */
