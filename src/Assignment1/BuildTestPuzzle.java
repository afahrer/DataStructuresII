package Assignment1;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class BuildTestPuzzle {
    public static void main(String[] args) {
        int[][] puzzle = {
        {5,3,0,0,7,0,0,0,0},
        {6,0,0,1,9,5,0,0,0},
        {0,9,8,0,0,0,0,6,0},
        {8,0,0,0,6,0,0,0,3},
        {4,0,0,8,0,3,0,0,1},
        {7,0,0,0,2,0,0,0,6},
        {0,6,0,0,0,0,2,8,0},
        {0,0,0,4,1,9,0,0,5},
        {0,0,0,0,8,0,0,7,9},
        };
        try {
            FileOutputStream fileOut = new FileOutputStream("9x9.dat", true);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(puzzle);
            objectOut.close();
            fileOut.close();
            System.out.println("The Object has been successfully written to a file\n");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
