package Assignment04;

public class AVLTree<T extends Comparable> implements BalancedTree<T> {

    private class Node {
        T item;
        int height = 0;
        Node left;
        Node right;

        Node(T item) {
            this(item, null, null, 1);
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
        if (r == null && l == null) return 0;
        if (r == null) return l.height;
        if (l == null) return r.height;
        return Math.max(l.height, r.height);
    }

    @Override
    public void insert(T val) {
        root = insert(val, root);
    }

    private Node insert(T val, Node r) {
        if (r == null)
            return new Node(val);

        if (r.item.compareTo(val) > 0)
            r.left = insert(val, r.left);

        else if (r.item.compareTo(val) < 0)
            r.right = insert(val, r.right);

        r.height = 1 + max(r.left, r.right);
        return rebalanceTree(r);
    }

    @Override
    public void delete(T val) {
        root = delete(val, root);
    }

    private Node delete(T val, Node r) {
        if (r == null) return r;
        if (r.item.compareTo(val) > 0) r.left = delete(val, r.left);
        else if (r.item.compareTo(val) < 0) r.right = delete(val, r.right);
        else {
            if (r.left == null) return r.right;
            else if (r.right == null) return r.left;

            r.item = minVal(r.right);
            r.right = delete(r.item, r.right);
        }
        r.height = 1 + max(r.left, r.right);

        return rebalanceTree(r);
    }

    private T minVal(Node r) {
        while (r.left != null) {
            r = r.left;
        }
        return r.item;
    }

    @Override
    public boolean contains(T val) {
        return contains(val, root);
    }

    private boolean contains(T val, Node r) {
        if (r == null) return false;
        if (r.item == val) return true;
        if (r.item.compareTo(val) > 0) return contains(val, r.left);
        if (r.item.compareTo(val) < 0) return contains(val, r.right);
        return false;
    }

    @Override
    public boolean isFullTree() {
        return isFullTree(root);
    }

    private boolean isFullTree(Node r) {
        if (r == null) return true;
        if (r.left == null ^ r.right == null) return false;
        return isFullTree(r.left) && isFullTree(r.right);
    }

    @Override
    public boolean isBalancedTree() {
        return isBalancedTree(root);
    }

    private boolean isBalancedTree(Node r) {
        int balance = balanceValue(r);
        return balance >= -1 && balance <= 1;
    }

    private int balanceValue(Node r) {
        if (r == null || r.left == null && r.right == null) return 0;
        if (r.right == null) return r.left.height;
        if (r.left == null) return 0 - r.right.height;
        return r.left.height - r.right.height;
    }
    private Node rebalanceTree(Node r) {
        if(!isBalancedTree(r)) {
            if(balanceValue(r) < 0) {
                r = rotateLeft(r);
                if(balanceValue(r) > 1) {
                    r = rotateRight(r);
                    r.right = rotateRight(r.right);
                    r = rotateLeft(r);
                }
            }
            else {
                r = rotateRight(r);
                if(balanceValue(r) > 1) {
                    r = rotateLeft(r);
                    r.left = rotateLeft(r.left);
                    r = rotateRight(r);
                }
            }
        }
        return r;
    }

    @Override
    public int nodeCount() {
        return nodeCount(root);
    }

    private int nodeCount(Node r) {
        return r == null ? 0 : 1 + nodeCount(r.left) + nodeCount(r.right);
    }

    @Override
    public int treeHeight() {
        return root.height;
    }
}
