import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.*;
import java.util.LinkedList;


public class Deque<Item> implements Iterable<Item> {

    private Node<Item> firstPointer;
    private Node<Item> lastPointer;
    private int dequeSize;

    public static class Node<Item> {
        private Item item;
        private Node<Item> next;
        private Node<Item> previous;
    }


    // construct an empty deque
    public Deque() {
        
        firstPointer = null;
        lastPointer = null;
        dequeSize = 0;

    }

    // is the deque empty?
    public boolean isEmpty() {
        
        return firstPointer.equals(lastPointer);

    }

    // return the number of items on the deque
    public int size() {
        return dequeSize;
    }

    // add the item to the front
    public void addFirst(Item item) {

        Node<Item> oldFirst = firstPointer;
        firstPointer = new Node<Item>();
        firstPointer.item = item;
        firstPointer.previous = null;
        dequeSize++;
        firstPointer.next = 
        oldFirst = firstPointer;

    }

    // add the item to the back
    public void addLast(Item item) {

    //implement a if function to see if blah blah blah        

        Node<Item> oldLast = lastPointer;
        lastPointer = new Node<Item>();
        lastPointer.item = item;
        lastPointer.next = null;
        dequeSize++;
        oldLast = lastPointer;
    }

    // remove and return the item from the front
    public Item removeFirst() {

    }

    // remove and return the item from the back
    public Item removeLast() {

        Node<Item> oldLast = lastPointer;
        lastPointer.item = lastPointer.previous;

    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return 
    }

    // unit testing (required)
    public static void main(String[] args) {

    }
    
}