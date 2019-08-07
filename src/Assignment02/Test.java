package Assignment02;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {

        BinarySearchTree<Integer> tree1 = new BinarySearchTree<Integer>();
        tree1.add(50);
        tree1.add(25);
        tree1.add(13);
        tree1.add(33);
        tree1.add(5);
        tree1.add(15);
        tree1.add(1);
        tree1.add(0);
        tree1.add(75);
        tree1.add(60);
        tree1.add(55);
        tree1.add(65);
        tree1.add(90);
        tree1.add(80);
        tree1.add(100);
        tree1.add(101);
        tree1.add(102);
        System.out.println("tree1.isLeaf(0) " + tree1.isLeaf(0));
        System.out.println("tree1.isLeaf(102) " + tree1.isLeaf(102));
        System.out.println("tree1.isLeaf(5) " + tree1.isLeaf(5));
        System.out.println("tree1.isLeaf(100) " + tree1.isLeaf(100));
        //internal
        tree1.delete(5);
        tree1.delete(100);
        //leaf
        tree1.delete(0);
        tree1.delete(102);
        printTreeDetails(tree1);

        BinarySearchTree<Double> tree2 = new BinarySearchTree<Double>();
        tree2.add(50.45);
        tree2.add(25.32);
        tree2.add(75.23);
        tree2.add(33.65);
        tree2.add(0.0);
        tree2.add(56.54);
        tree2.add(77.45);
        tree2.add(55.34);
        tree2.add(87.1324);
        tree2.add(100.232);
        tree2.add(99.1232);
        tree2.add(24.324);
        tree2.add(66.232);
        tree2.add(54.23);
        tree2.add(82.21);
        tree2.add(52.232);
        //internal
        tree2.delete(75.23);
        tree2.delete(55.34);
        //leaf
        tree2.delete(0.0);
        tree2.delete(100.232);
        printTreeDetails(tree2);
        System.out.println("\ntree2.isLeaf(82.21) " + tree2.isLeaf(82.21));
        System.out.println("tree2.isLeaf(24.324) " + tree2.isLeaf(24.324));
        System.out.println("tree2.isLeaf(50.45) " + tree2.isLeaf(50.45));
        System.out.println("tree2.isLeaf(54.23) " + tree2.isLeaf(54.23));

        BinarySearchTree<String> tree3 = new BinarySearchTree<String>();
        tree3.add("pizza");
        tree3.add("reader");
        tree3.add("add");
        tree3.add("day");
        tree3.add("string");
        tree3.add("heart");
        tree3.add("web");
        tree3.add("queen");
        tree3.add("yell");
        tree3.add("we");
        tree3.add("safe");
        tree3.add("donut");
        tree3.add("test");
        tree3.add("baby");
        tree3.add("zebra");
        tree3.add("sandwich");
        //internal
        tree3.delete("pizza");
        tree3.delete("web");
        //leaf
        tree3.delete("add");
        tree3.delete("zebra");
        printTreeDetails(tree3);
        tree3.saveToFile("tree3.csv");
        //just to prove that this is from a file root is set to null
        tree3.removeAll();

        tree3.buildTreeFromFile("tree3.csv", 12);
        System.out.println("\nBalanced rebuild from file");
        printTreeDetails(tree3);
        System.out.println("\ntree3.isLeaf(\"yell\") " + tree3.isLeaf("yell"));
        System.out.println("tree3.isLeaf(\"baby\") " + tree3.isLeaf("baby"));
        System.out.println("tree3.isLeaf(\"sandwich\") " + tree3.isLeaf("sandwich"));
        System.out.println("tree3.isLeaf(\"heart\") " + tree3.isLeaf("heart"));
    }

    private static void printTreeDetails(BinarySearchTree tree) {
        System.out.println();
        System.out.println("Number of Nodes: " + tree.count());
        System.out.println("Min Height: " + tree.minHeight());
        System.out.println("Max Height: " + tree.maxHeight());
        System.out.println("Balanced: " + tree.isBalanced());
        System.out.println("Complete: " + tree.isComplete());
        System.out.println("Full: " + tree.isFull());
        System.out.println("\nPre Order: ");
        tree.printPreOrder();
        System.out.println("\nIn Order: ");
        tree.printInOrder();
        System.out.println("\nPost Order: ");
        tree.printPostOrder();
    }
}
