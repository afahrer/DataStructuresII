package Assignment1;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Test {
    public static int[][] puzzle;
    public static int boardWidth;

    public static void main(String[] args) {
        puzzle = getPuzzle();
        boardWidth = puzzle.length;
        printPuzzle();
        solve(0,0);
        printPuzzle();
    }

    private static void printPuzzle() {
        System.out.println("\n\n");
        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < boardWidth; j++) {
                System.out.print(puzzle[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static boolean solve(int row, int col) {
        if(row == boardWidth) {
            return true;
        }
        if(col == boardWidth) {
            return solve(row+1, 0);
        }
        if(puzzle[row][col] != 0) {
            return solve(row, col+1);
        }
        for (int i = 1; i < boardWidth+1; i++) {
            if(check(row, col, i)) {
                puzzle[row][col] = i;
                if(solve(row, col+1)) return true;
                else puzzle[row][col] = 0;
            }
        }
        return false;
    }

    private static boolean check(int row, int col, int num) {

        for (int i = 0; i < boardWidth; i++) {
            if(puzzle[row][i] == num) return false;
        }

        for (int i = 0; i < boardWidth; i++) {
            if(puzzle[i][col] == num) return false;
        }

        int boxWidth = (int)Math.sqrt(boardWidth);
        int multipleRow = boxWidth;
        int multipleCol = boxWidth;

        while(row >= multipleRow) {
            multipleRow+=boxWidth;
        }

        while(col >= multipleCol) {
            multipleCol+=boxWidth;
        }

        for (int i = multipleRow-boxWidth; i < multipleRow; i++) {
            for (int j = multipleCol-boxWidth; j < multipleCol; j++) {
                if(puzzle[i][j] == num) return false;
            }
        }

        return true;
    }

    private static int[][] getPuzzle() {
        ObjectInputStream ioStream = null;
        FileInputStream filestream = null;
        int[][] puzzle = null;
        try {
            filestream = new FileInputStream("puzzle1.dat");
            ioStream = new ObjectInputStream(filestream);
            puzzle = (int[][])ioStream.readObject();
        } catch (EOFException e) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ioStream.close();
                filestream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return puzzle;
    }

}
