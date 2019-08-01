package Assignment01;
/*
    Author: Adam Fahrer
    Date: July 30, 2019
    Purpose: To get an int[][] from file that contains a Sudoku puzzle then use
             backtracking to solve the puzzle and write the new puzzle to a
             file called solution.dat.
*/

import java.io.*;

public class Sudoku {

    private static int[][] puzzle;
    private static int     boardWidth;

    public static void main(String[] args) {
        puzzle = getPuzzleFromFile();
        if (puzzle == null) {
            System.out.println("Puzzle Not Found");
            return;
        }
        boardWidth = puzzle.length;
        System.out.println("Original Puzzle: ");
        printPuzzle();
        solve(0, 0);
        System.out.println("\nSolved Puzzle: ");
        printPuzzle();
        writeToFile(puzzle);
    }

    private static void printPuzzle() {
        System.out.println();
        int squares = (int) Math.sqrt(boardWidth);
        for (int i = 0; i < boardWidth; i++) {
            if (i % squares == 0 && i != 0) {
                for (int j = 0; j < boardWidth + squares - 1; j++) {
                    System.out.print("\t_");
                }
                System.out.println("\n");
            }
            System.out.print("[\t");
            for (int j = 0; j < boardWidth; j++) {
                if (j % squares == 0 && j != 0) System.out.print("|\t");
                if (puzzle[i][j] >= 10) System.out.print(getLetter(puzzle[i][j]) + "\t");
                else System.out.print(puzzle[i][j] + "\t");
            }
            System.out.print("]\n");
        }
    }

    // recursive backtracking method that attempts to solve the puzzle
    private static boolean solve(int row, int col) {
        if (row == boardWidth) return true;
        if (col == boardWidth) return solve(row + 1, 0);
        if (puzzle[row][col] != 0) return solve(row, col + 1);
        for (int i = 1; i < boardWidth + 1; i++) {
            if (check(row, col, i)) {
                puzzle[row][col] = i;
                if (solve(row, col + 1)) return true;
                else puzzle[row][col] = 0;
            }
        }
        return false;
    }

    // check to see if a number is valid in the row, column and square
    private static boolean check(int row, int col, int num) {

        for (int i = 0; i < boardWidth; i++) {
            if (puzzle[row][i] == num) return false;
        }
        for (int i = 0; i < boardWidth; i++) {
            if (puzzle[i][col] == num) return false;
        }

        int boxWidth    = (int) Math.sqrt(boardWidth);
        int multipleRow = boxWidth;
        int multipleCol = boxWidth;

        while (row >= multipleRow) {
            multipleRow += boxWidth;
        }
        while (col >= multipleCol) {
            multipleCol += boxWidth;
        }
        for (int i = multipleRow - boxWidth; i < multipleRow; i++) {
            for (int j = multipleCol - boxWidth; j < multipleCol; j++) {
                if (puzzle[i][j] == num) return false;
            }
        }
        return true;
    }

    // returns the corresponding letter for numbers >= 10
    private static char getLetter(int num) {
        switch (num) {
            case 10:
                return 'A';
            case 11:
                return 'B';
            case 12:
                return 'C';
            case 13:
                return 'D';
            case 14:
                return 'E';
            case 15:
                return 'F';
            case 16:
                return 'G';
        }
        return ' ';
    }

    private static int[][] getPuzzleFromFile() {
        ObjectInputStream ioStream   = null;
        FileInputStream   filestream = null;
        int[][]           puzzle     = null;
        try {
            filestream = new FileInputStream("puzzle1.dat");
            ioStream   = new ObjectInputStream(filestream);
            puzzle     = (int[][]) ioStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert ioStream != null;
                ioStream.close();
                filestream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return puzzle;
    }

    private static void writeToFile(Object o) {
        try {
            FileOutputStream   fileOut   = new FileOutputStream("solution.dat");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(o);
            objectOut.close();
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
