package Assignment02;

import java.io.*;

public class BinarySearchTree<T extends Comparable> implements BSTInterface<T> {
    private class Node {
        T item;
        Node left;
        Node right;

        Node(T item) {
            this(item, null, null);
        }

        Node(T item, Node left, Node right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;
    private FileWriter csv;

    public BinarySearchTree() {
        root = null;
        try {
            csv = new FileWriter("tree.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int count() {
        return count(root);
    }

    private int count(Node r) {
        return r == null ? 0 : 1 + count(r.left) + count(r.right);
    }

    public boolean isLeaf(T value) {
        Node temp = isLeaf(value, root);
        if (temp.item == null) throw new RuntimeException("Item not Found");
        return temp.left == null && temp.right == null;
    }

    private Node isLeaf(T value, Node r) {
        if (r == null) return null;
        if (r.item.equals(value)) return r;
        Node temp = isLeaf(value, r.left);
        return temp == null ? isLeaf(value, r.right) : temp;
    }

    public int minHeight() {
        return minHeight(root);
    }

    private int minHeight(Node r) {
        return r == null ? 0 : 1 + Math.min(minHeight(r.left), minHeight(r.right));
    }

    public int maxHeight() {
        return maxHeight(root);
    }

    private int maxHeight(Node r) {
        return r == null ? 0 : 1 + Math.max(maxHeight(r.left), maxHeight(r.right));
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node r) {
        if (r == null) return true;
        return maxHeight(r.left) - maxHeight(r.right) <= 1 && maxHeight(r.left) - maxHeight(r.right) >= -1;
    }

    public boolean isComplete() {
        int height = maxHeight();
        return isComplete(root, 1, height);
    }

    private boolean isComplete(Node r, int pos, int height) {
        if (pos == height - 1 && r == null) return false;
        if (pos == height - 1) return true;
        if (r == null || r.left == null ^ r.right == null) return false;
        return isComplete(r.left, pos + 1, height) && isComplete(r.right, pos + 1, height);
    }

    public boolean isFull() {
        return isFull(root);
    }

    private boolean isFull(Node r) {
        if (r == null) return true;
        if (r.left == null ^ r.right == null) return false;
        return isFull(r.left) && isFull(r.right);
    }

    public void printInOrder() {
        printInOrder(root);
        System.out.println();
    }

    private void printInOrder(Node r) {
        if (r == null) return;
        printInOrder(r.left);
        System.out.print(r.item + ",");
        printInOrder(r.right);
    }

    public void printPreOrder() {
        printPreOrder(root);
        System.out.println();
    }

    private void printPreOrder(Node r) {
        if (r == null) return;
        System.out.print(r.item + ",");
        printInOrder(r.left);
        printInOrder(r.right);
    }

    public void printPostOrder() {
        printPostOrder(root);
        System.out.println();
    }

    private void printPostOrder(Node r) {
        if (r == null) return;
        printInOrder(r.left);
        printInOrder(r.right);
        System.out.print(r.item + ",");
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void add(T item) {
        if (contains(item)) throw new BSTException("Item Already Exists " + item);
        if (root == null) {
            root = new Node(item);
            return;
        }
        add(item, root);
    }

    private void add(T item, Node r) {
        if (r.item.compareTo(item) > 0) {
            if (r.left == null) {
                r.left = new Node(item);
                return;
            }
            add(item, r.left);
            return;
        }
        if (r.right == null) {
            r.right = new Node(item);
            return;
        }
        add(item, r.right);
    }

    @Override
    public boolean contains(T item) {
        return contains(item, root);
    }

    private boolean contains(T item, Node r) {
        if (r == null) return false;
        if (r.item == item) return true;
        return r.item.compareTo(item) > 0 ? contains(item, r.left) : contains(item, r.right);
    }

    @Override
    public void delete(T item) {
        root = delete(item, root);
    }

    private Node delete(T item, Node r) {
        if (r == null) throw new BSTException("Item does not exist for deletion");
        if (r.item.compareTo(item) > 0)
            r.left = delete(item, r.left);
        else if (r.item.compareTo(item) < 0)
            r.right = delete(item, r.right);
        else {
            if (r.left == null)
                return r.right;
            else if (r.right == null)
                return r.left;

            r.item = minVal(r.right);
            r.right = delete(r.item, r.right);
        }
        return r;
    }

    private T minVal(Node r) {
        while (r.left != null) {
            r = r.left;
        }
        return r.item;
    }

    @Override
    public void removeAll() {
        root = null;
    }

    public void treeBuildFromSorted(T[] list) {
        treeBuildFromSorted(list, 0, list.length);
    }

    private void treeBuildFromSorted(T[] list, int start, int end) {
        if (start == 0 && end == 1) {
            add(list[0]);
            return;
        }
        if (start == end - 1) return;
        int mid = (end + start) / 2;
        add(list[mid]);
        treeBuildFromSorted(list, start, mid);
        treeBuildFromSorted(list, mid, end);
    }

    public void saveToFile(){
        try {
            saveToFile(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveToFile(Node r) throws IOException {
        if (r == null) return;
        saveToFile(r.left);
        csv.append(r.item.toString());
        csv.append(",");
//        csv.append("\n");

        saveToFile(r.right);
        if (r == root) {
            csv.flush();
            csv.close();
        }
    }

    public void buildTreeFromFile(String fileName) {
        BufferedReader csvReader = null;
        try {
            csvReader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String row;
        String[][] data = new String[1000][1];
        removeAll();
        int count = 0;
        try {
            while ((row = csvReader.readLine()) != null) {
                data[count] = row.split(",");
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
