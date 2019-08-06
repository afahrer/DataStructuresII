package Assignment02;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        Random rand = new Random();
        tree.add(50);
        tree.add(66);
        tree.add(43);
        tree.add(73);
        tree.add(13);
        tree.add(84);
        tree.add(11);
        tree.add(4);
        tree.printPreOrder();
        System.out.println();
        tree.delete(50);
        tree.printPreOrder();
    }
}
