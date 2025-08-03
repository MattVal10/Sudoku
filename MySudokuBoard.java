// Matthew Valencia
// CS 143
// HW #3: Sudoku #3 (solve)

// This program will read a file. Fill a 2D array and then fill out the board 
// with either a blank space if the file contains a '.' or a digit that the file has.
// Also checks if a sudoku board is valid or solved using methods.
// Also solves the Sudoku board using recursive backtracking.

import java.util.*;
import java.io.*;

public class MySudokuBoard {

    char[][] sudokuContents = new char[9][9];

    // pre: needs a readable file in a 9x9 Sudoku form and either has digits or '.'
    // post: fills sudokuContents with Charactors from the file, using either a ' '
    //      for blanks or digit charactors in thier spaces
    public MySudokuBoard(String fileName) {
        try {
            
        
            Scanner scanny = new Scanner(new File(fileName));

            for (int i = 0; i < 9; i++) {
                String line = scanny.nextLine();

                for(int j = 0; j < 9; j++) {
                    char charactor = line.charAt(j);

                    if(Character.isDigit(charactor)) {
                        sudokuContents[i][j] = charactor;
                    } else if (charactor == '.') {
                        sudokuContents[i][j] = ' ';
                    }
                }
            }

            scanny.close();

        } catch (FileNotFoundException e) {
            System.out.println("Please try again with a correct file name");
        }
    }

    // Helper Method: checks if all charactors are valid 
    // pre: none
    // post: returns true if all characters are valid digits (1-9) or blanks
    private boolean isValidData() {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                char ch = sudokuContents[i][j];
                if (!(Character.isDigit(ch) && ch != '0') && ch != ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    // Helper Method: checks if rows have duplicate digits
    // pre:none
    // post: returns true if all rows have no duplicate digits
    private boolean isRowsValid() {
        for(int i = 0; i < 9; i++) {
            Set<Character> seen = new HashSet<>();
            for(int j = 0; j < 9; j++) {
                char ch = sudokuContents[i][j];
                if (ch != ' ') {
                    if (seen.contains(ch)) {
                        return false;
                    }
                    seen.add(ch);
                }
            }
        }
        return true;
    }

    //Helper method: check if columns have duplicate digits
    // pre: none
    // post: returns true if all columns have no duplicate digits
    private boolean isColumnValid() {
        for (int j = 0; j < 9; j++) {
            Set<Character> seen = new HashSet<>();
            for(int i = 0; i < 9; i++) {
                char ch = sudokuContents[i][j];
                if (ch != ' ') {
                    if (seen.contains(ch)) {
                        return false;
                    }
                    seen.add(ch);
                }
            }
        }
        return true;
    }

    // pre: box is in range of 1 to 9
    // post: returns 3x3 array with the box's contents
    private char[][] miniSqaure(int box) {
        char[][] mini = new char[3][3];
        for(int r = 0; r < 3; r++) {
            for(int c = 0; c < 3; c++) {
                mini[r][c] = sudokuContents[(box - 1)/ 3 * 3 + r][(box - 1) % 3 * 3 + c];
            }
        }
        return mini;
    }

    //Helper Method: checks if 3x3 boxes have duplicate digits
    // Pre: none
    // Post: returns true if all 3x3 boxes have no duplicate digits
    private boolean isBoxValid() {
        for(int box = 1; box <= 9; box++) {
            char[][] mini = miniSqaure(box);
            Set<Character> seen = new HashSet<>();

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j <3; j++) {
                    char ch = mini[i][j];
                    if (ch != ' ') {
                        if (seen.contains(ch)) {
                            return false;
                        }
                        seen.add(ch);
                    }
                }
            }
        }
        return true;
    }
    
    // pre: none
    // post: returns true if the board contains only valid values and no duplicates
    public boolean isValid() {
        return isValidData() && isRowsValid() && isColumnValid() && isBoxValid();
    }

    // Pre: none
    // Post: returns true if the board is completely filled and each digit 1 to 9 appears exactly 
        // 9 itmes
    public boolean isSolved() {
        Map<Character, Integer> countMap = new HashMap<>();

        for(int i =0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                char ch = sudokuContents[i][j];
                if (ch != ' ') {
                    countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
                }
            }
        }

        for(char digit = '1'; digit <= '9'; digit++) {
            if (countMap.getOrDefault(digit,0) != 9) {
                return false;
            }
        }
        return true;
    }

    // pre: none
    // post: returns a String representing the Sudoku baord in a grid with boarders
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        String border = "---------------------\n";
        sb.append(border);

        for (int i = 0; i < 9; i++) {
            sb.append("| ");
            for (int j = 0; j < 9; j++) {
                sb.append(sudokuContents[i][j]).append(" ");
            }
            sb.append("|\n");
        }
        sb.append(border);
        return sb.toString();
    }

    // pre: the current board may be partially filled with digits and blanks (' ')
    // post: attempts to solve the board using recursive backtracking; returns true if solved
    public boolean solve() {
        boolean boardSolved = false;

        if (!isValid()) {
            return false;
        }

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (sudokuContents[row][col] == ' ') {
                    for (char digit = '1'; digit <= '9'; digit++) {
                        sudokuContents[row][col] = digit;

                        if (isValid()) {
                            boardSolved = solve();
                            if (boardSolved) {
                                return true;
                            }
                        }

                        sudokuContents[row][col] = ' '; 
                    }
                    return false; 
                }
            }
        }

        boardSolved = isSolved();
        return boardSolved;
    }
}