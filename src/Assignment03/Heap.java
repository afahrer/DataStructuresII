package Assignment03;

public class Heap {

    private Person[] items;
    private int size;
    private final int capacity;

    public Heap() {
        this(127);
    }
    public Heap(int capacity) {
        this.capacity = capacity;
        createHeap();
    }
    public void createHeap() {
        this.size = 0;
        this.items = new Person[capacity];
    }

    public boolean isEmpty() {
        return items[0] == null;
    }

    public void heapInsert(Person person) {
        if (size >= capacity) throw new HeapException("Heap is Full");
        items[size] = person;
        int place = size;
        int parent = (place - 1) / 2;
        while(parent >= 0 && items[place].getPriority() < items[parent].getPriority()) {
            swap(place, parent);
            place = parent;
            parent = (place - 1) / 2;
        }
        size++;
    }

    private void swap(int person1, int person2) {
        Person temp = items[person1];
        items[person1] = items[person2];
        items[person2] = temp;
    }

    public Person heapDelete() {
        if(size == 0) throw new HeapException("Heap is Empty");
        Person temp = items[0];
        items[0] = items[size - 1];
        items[size - 1] = null;
        size--;
        rebuildHeap(0);
        return temp;
    }

    private void rebuildHeap(int rootIndex) {
        int child = 2 * rootIndex + 1;
        int rightChild = child + 1;
        if(items[child] != null) {
            if(items[rightChild] != null && items[rightChild].getPriority() < items[child].getPriority()) {
                child = rightChild;
            }
            if(items[rootIndex].getPriority() > items[child].getPriority()) {
                swap(rootIndex,child);
                rebuildHeap(child);
            }
        }
    }

    public int getSize() {
        return size;
    }
    public Person peek() {
        return items[0];
    }

    public Person[] getItems() {
        return items;
    }
}
