package Assignment03;
/*
    Author: Adam Fahrer
    Date: August 11, 2019
    Purpose: Test program for the priority queue using min heap implementation
*/
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {


        PriorityQueue queue = new PriorityQueue();

        //a)add the first 31 items
        Scanner in = new Scanner(new FileReader("Assign3_Data1.txt"));
        StringBuilder sb = new StringBuilder();
        while(in.hasNext()) {
            sb.append(in.next() + " ");
        }
        in.close();
        String[] data = sb.toString().split(" ");
        int index = 0;
        while (data[index] != null && index < 93) {
            queue.enqueue(new Person(data[index].charAt(0), data[index+1], data[index+2]));
            index+=3;
        }
        //b)report whether or not the list is empty
        System.out.println("List is Empty: " + queue.isEmpty() + "\n");
        //c)print the list
        queue.printPQueue();
        //d)remove two items and report the peek and peekPriority values
        queue.dequeue();
        queue.dequeue();
        System.out.println("Peek: " + queue.peek());
        System.out.println("Peek Priority: " + queue.peekPriority());
        //e)remove five items and report the peek and peekPriority values
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        System.out.println("Peek: " + queue.peek());
        System.out.println("Peek Priority: " + queue.peekPriority());
        //f)remove three items and report the peek and peekPriority values
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        System.out.println("Peek: " + queue.peek());
        System.out.println("Peek Priority: " + queue.peekPriority());
        System.out.println();
        //g)print the list
        queue.printPQueue();
        //h)clear the list and report whether or not it is empty
        queue.dequeueAll();
        System.out.println("\n\nList is Empty: " + queue.isEmpty() + "\n\n");
        //i)add the remaining items in the file
        while(index < data.length && data[index] != null) {
            queue.enqueue(new Person(data[index].charAt(0), data[index+1], data[index+2]));
            index+=3;
        }
        //j)print the list
        queue.printPQueue();
    }
}
