package Assignment04;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        Scanner in = null;
        try {
            in = new Scanner(new FileReader("Assign4_Data1.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        while(in.hasNext()) {
            sb.append(in.next() + " ");
        }
        in.close();
        String[] data = sb.toString().split(" ");
        int added = 0;
        int removed = 0;
        for (int i = 0; i < data.length; i++) {
            if(data[i].equals("I")) {
                tree.insert(Integer.parseInt(data[++i]));
                added++;
            }
            else if(data[i].equals("D")) {
                tree.delete(Integer.parseInt(data[++i]));
                removed++;
            }
            else if(data[i].equals("R")){
                System.out.println("Added: " + added + " Removed: " + removed +
                        "\nHeight: " + tree.treeHeight() + " Balanced: " + tree.isBalancedTree() +
                        "\nIs Full: " + tree.isFullTree());
                System.out.println();
            }
        }
    }
}
