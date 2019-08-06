package Assignment02;

public interface BSTInterface<T> {
    boolean isEmpty();
    void add(T item);
    boolean contains(T item);
    void delete(T item);
    void removeAll();
}
