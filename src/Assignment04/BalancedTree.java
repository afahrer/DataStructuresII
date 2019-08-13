package Assignment04;

public interface BalancedTree<T> {
    boolean isEmpty();

    void insert(T val);

    void delete(T val);

    boolean contains(T val);

    boolean isFullTree();

    boolean isBalancedTree();

    int nodeCount();

    int treeHeight();
}
