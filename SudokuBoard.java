// Matthew Valencia
// CS 143
// HW #1: Sudoku #1 (Board Setup)

// This program will read a file. Fill a 2D array and then fill out the board 
// with either a blank space if the file contains a '.' or a digit that the file has

import java.util.*;
import java.io.*;

public class SudokuBoard {

    char[][] sudokuContents = new char[9][9];

    // pre: needs a readable file in a 9x9 Sudoku form and either has digits or '.'
    // post: fills sudokuContents with Charactors from the file, using either a ' '
    //      for blanks or digit charactors in thier spaces
    public SudokuBoard(String fileName) throws FileNotFoundException {

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
}