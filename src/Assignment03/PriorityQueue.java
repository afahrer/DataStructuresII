package Assignment03;

/*
    Author: Adam Fahrer
    Date: August 11, 2019
    Purpose: Priority queue for person objects using a minheap structure
*/

public class PriorityQueue {

    private Heap heap;

    public PriorityQueue() {
        this(127);
    }
    public PriorityQueue(int capacity) {
        this.heap = new Heap(capacity);
    }

    public boolean isEmpty() {
        return heap.getSize() == 0;
    }

    public void enqueue(Person person) {
        heap.heapInsert(person);
    }
    public Person dequeue() {
        return heap.heapDelete();
    }
    public Person peek() {
        return heap.peek();
    }

    public char peekPriority() {
        return peek().getPriority();
    }
    public void dequeueAll() {
        heap.createHeap();
    }
    public int size() {
        return heap.getSize();
    }
    public void printPQueue() {
        for (Person person: heap.getItems()) {
            if(person != null) System.out.println(person + "\n");
        }
    }
}
