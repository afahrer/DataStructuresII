package Assignment02;

public class Test {
    public static void main(String[] args) {
        Integer[] list = {0,11,22,34,55,56,67,76,78,88,99,100};
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.treeBuildFromSorted(list);
        printTreeDetails(tree);
//        BinarySearchTree<Integer> test = new BinarySearchTree<Integer>();
//        test.add(5);
//        test.add(7);
//        test.add(8);
//        test.add(3);
//        test.add(2);
//        test.add(6);
//        test.add(4);
//        printTreeDetails(test);
//        BinarySearchTree<Integer> treeInt = new BinarySearchTree<Integer>();
//        treeInt.add(50);
//        treeInt.add(25);
//        treeInt.add(75);
//        treeInt.add(33);
//        treeInt.add(0);
//        treeInt.add(56);
//        treeInt.add(77);
//        treeInt.add(55);
//        treeInt.add(87);
//        treeInt.add(100);
//        treeInt.add(99);
//        treeInt.add(24);
//        treeInt.add(66);
//        treeInt.add(54);
//        treeInt.add(82);
//        treeInt.add(52);
//        treeInt.delete(77);
//        treeInt.delete(55);
//        treeInt.delete(0);
//        treeInt.delete(100);
//        printTreeDetails(treeInt);
//        BinarySearchTree<Double> treeDouble = new BinarySearchTree<Double>();
//        treeDouble.add(50.45);
//        treeDouble.add(25.32);
//        treeDouble.add(75.23);
//        treeDouble.add(33.65);
//        treeDouble.add(0.0);
//        treeDouble.add(56.54);
//        treeDouble.add(77.45);
//        treeDouble.add(55.34);
//        treeDouble.add(87.1324);
//        treeDouble.add(100.232);
//        treeDouble.add(99.1232);
//        treeDouble.add(24.324);
//        treeDouble.add(66.232);
//        treeDouble.add(54.23);
//        treeDouble.add(82.21);
//        treeDouble.add(52.232);
//        treeDouble.delete(77.45);
//        treeDouble.delete(55.34);
//        treeDouble.delete(0.0);
//        treeDouble.delete(100.232);
//        printTreeDetails(treeDouble);
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
