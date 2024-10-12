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
        if (item.equals(null)) {
            throw new IllegalArgumentException("No numbers");
        }
        Node<Item> oldFirst = firstPointer;
        firstPointer = new Node<Item>();
        firstPointer.item = item;
        firstPointer.next = oldFirst;
        if (isEmpty()) {
            lastPointer = firstPointer;
        }
        dequeSize++;

    }

    // add the item to the back
    public void addLast(Item item) {
        if (item.equals(null)) {
            throw new IllegalArgumentException("No numbers");
        }
    //implement a if function to see if blah blah blah        
    Node<Item> oldLast = lastPointer;
    lastPointer = new Node<Item>();
    lastPointer.item = item;
    lastPointer.previous = oldLast;
    if (isEmpty()) {
        firstPointer = lastPointer;
    }
    dequeSize++;
        
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (size()<1) {
            throw new NoSuchElementException("Queue underflow");
        }
        Node<Item> first = firstPointer;
        firstPointer = firstPointer.next;
        if (isEmpty()) {
            lastPointer = null;
        }
        dequeSize--;
        return first.item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (size()<1) {
            throw new NoSuchElementException("Queue underflow");
        }
        Node<Item> last = lastPointer;
        lastPointer = lastPointer.previous;
        if (isEmpty()) {
            firstPointer = null;
        }
        dequeSize--;
        return last.item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return 
    }

    // unit testing (required)
    public static void main(String[] args) {

    }
    
}