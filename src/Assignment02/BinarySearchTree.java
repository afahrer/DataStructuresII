package Assignment02;

public class BinarySearchTree<T extends Comparable> implements BSTInterface<T>{
    private class Node {
        T item;
        Node left;
        Node right;
        Node(T item) {
            this(item,null,null);
        }
        Node(T item, Node left, Node right) {
            this.item  = item;
            this.left  = left;
            this.right = right;
        }
    }
    private Node root;

    public int count(){
        return count(root);
    }

    private int count(Node r) {
        return r == null ? 0 : 1 + count(r.left) + count(r.right);
    }

    public boolean isLeaf(T value) {
        Node temp = isLeaf(value, root);
        if(temp.item == null) throw new RuntimeException("Item not Found");
        return temp.left == null && temp.right == null;
    }

    private Node isLeaf(T value, Node r) {
        if(r == null) return null;
        if(r.item.equals(value)) return r;
        Node temp = isLeaf(value, r.left);
        return temp == null ? isLeaf(value,r.right) : temp;
    }

    public boolean isFull() {
        return isFull(root);
    }

    private boolean isFull(Node r) {
        if(r == null) return true;
        if(r.left == null ^ r.right == null) return false;
        boolean full = isFull(r.left) && isFull(r.right);
        return full;
    }

    public void printInOrder() {printInOrder(root);}
    private void printInOrder(Node r) {
        if (r == null) return;
        printInOrder(r.left);
        System.out.print(r.item + ", ");
        printInOrder(r.right);
    }
    public void printPreOrder() {printPreOrder(root);}
    private void printPreOrder(Node r) {
        if (r == null) return;
        System.out.print(r.item + ", ");
        printInOrder(r.left);
        printInOrder(r.right);
    }
    public void printPostOrder() {printPostOrder(root);}
    private void printPostOrder(Node r) {
        if (r == null) return;
        printInOrder(r.left);
        printInOrder(r.right);
        System.out.print(r.item + ", ");
    }
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void add(T item) {
        if(root == null) {
            root = new Node(item);
            return;
        }
        add(item,root);
    }

    private void add(T item, Node r) {
        if(r.item.compareTo(item) > 0) {
            if(r.left == null) {
                r.left = new Node(item);
                return;
            }
            add(item,r.left);
            return;
        }
        if(r.right == null) {
            r.right = new Node(item);
            return;
        }
        add(item,r.right);
    }

    @Override
    public boolean contains(T item) {
        return contains(item, root);
    }

    private boolean contains(T item, Node r) {
        if(r == null) return false;
        if(r.item == item) return true;
        return contains(item, r.left) && contains(item, r.right);
    }

    @Override
    public void delete(T item) {
        delete(item, root);
    }

    private void delete(T item, Node r) {
        if (r == null) return;
        Node parent = null;
        Node curr = r;
        while(curr != null && curr.item != item) {
            parent = curr;
            if(r.item.compareTo(item) > 0) {
                curr = curr.left;
            }
            else curr = curr.right;
        }
        // item does not exist
        if(curr == null) return;
        // Node is Leaf
        if(curr.left == null && curr.right == null) {
            if(curr == root) removeAll();
            if(parent.left == curr) parent.left = null;
            else parent.right = null;
            return;
        }
        // node has two children
        if(curr.left != null && curr.right != null) {
            Node minRight = minValue(r.right);
            T min = minRight.item;
            delete(min, root);
            curr.item = min;
            return;
        }
        // node has one child
        Node child;
        if(curr.right != null) {
            child = curr.right;
        }
        child = curr.left;
        if(curr == root) {
            root = child;
            return;
        }
        if(curr == parent.left) {
            parent.left = child;
        }
        parent.right = child;
    }

    @Override
    public void removeAll() {
        root = null;
    }
    private Node minValue(Node r) {
        while(r.left != null) {
            r = r.left;
        }
        return r;
    }
}
