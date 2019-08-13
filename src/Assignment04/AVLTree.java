package Assignment04;

public class AVLTree<T extends Comparable> implements BalancedTree<T> {

    private class Node {
        T item;
        int height = 0;
        Node left;
        Node right;

        Node(T item) {
            this(item,null,null,1);
        }

        Node(T item, Node left, Node right, int height) {
            this.item = item;
            this.left = left;
            this.right = right;
            this.height = height;
        }
    }

    private Node root;

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    private Node rotateLeft(Node r) {
        Node newRoot = r.right;
        Node temp = newRoot.left;
        newRoot.left = r;
        r.right = temp;
        r.height = 1 + max(r.left, r.right);
        newRoot.height = 1 + max(newRoot.left, newRoot.right);
        return newRoot;
    }

    private Node rotateRight(Node r) {
        Node newRoot = r.left;
        Node temp = newRoot.right;
        newRoot.right = r;
        r.left = temp;
        r.height = 1 + max(r.left, r.right);
        newRoot.height = 1 + max(newRoot.left, newRoot.right);
        return newRoot;
    }

    private int max(Node l, Node r) {
        if(r == null) return l.height;
        if(l == null) return r.height;
        return Math.max(l.height, r.height);
    }

    @Override
    public void insert(T val) {
        root = insert(val, root);
    }

    private Node insert(T val, Node r){
        return r;
    }

    @Override
    public void delete(T val) {
        root = delete(val, root);
    }

    private Node delete(T val, Node r) {
        return r;
    }

    @Override
    public boolean contains(T val) {
        return false;
    }

    @Override
    public boolean isFullTree() {
        return false;
    }

    @Override
    public boolean isBalancedTree() {
        return false;
    }

    private int balanceValue(Node r) {
        return r == null ? 0 : r.left.height - r.right.height;
    }

    @Override
    public int nodeCount() {
        return 0;
    }

    @Override
    public int treeHeight() {
        return 0;
    }
}
