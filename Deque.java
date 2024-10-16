import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Rui Zhao attests that this code is their original work and was written in compliance with the class Academic Integrity and Collaboration Policy found in the syllabus. 
 */

 //One thing that was interesting within deque was that really thinking about the attributes of the pointers regarding the node class; though I have already thought of how to do it, I understood it through the arraylist way, not the node way. Now I can differentiate
//the difference between nonexisting order diagrams vs stored diagrams (names were made on the spot)
 //I believe without the inspiration from Queue.java, I wouldn't have thought to use Node static class, and im sure it would be a lot harder without it. 

public class Deque<Item> implements Iterable<Item> {

    private Node<Item> firstPointer;
    private Node<Item> lastPointer;
    private int dequeSize;

    private static class Node<Item> {
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
        
        return dequeSize == 0;

    }

    // return the number of items on the deque
    public int size() {
        return dequeSize;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("No numbers");
        }
        Node<Item> oldFirst = firstPointer;
        firstPointer = new Node<Item>();
        firstPointer.item = item;
        firstPointer.next = oldFirst;
        if (isEmpty()) {
            lastPointer = firstPointer;
            
        } else {
            oldFirst.previous = firstPointer;
        }
        dequeSize++;

    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("No numbers");
        }
    //implement a if function to see if blah blah blah        
    Node<Item> oldLast = lastPointer;
    lastPointer = new Node<Item>();
    lastPointer.item = item;
    
    lastPointer.previous = oldLast;
    if (isEmpty()) {
        firstPointer = lastPointer;
        
    } else {
        oldLast.next = lastPointer;
    }
    dequeSize++;
        
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        Node<Item> oldFirst = firstPointer;
        Item item = oldFirst.item;
    
        if (firstPointer.next != null) {
            firstPointer = firstPointer.next;
            firstPointer.previous = null; 
        } else {
            firstPointer = null;
            lastPointer = null;
        }
        dequeSize--;
        return item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        Node<Item> oldLast = lastPointer;
        Item item = oldLast.item;
        //if previous node exist, branch back to that one, else pointer meet
        if (lastPointer.previous != null) {
            lastPointer = lastPointer.previous;
            lastPointer.next = null; 
        } else {   
            firstPointer = null;
            lastPointer = null;
        }
        dequeSize--;
        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        
        return new IteratorDeque();

    }
    /**
     * constructs/implements the iterator abstract class
     */
    private class IteratorDeque implements Iterator<Item> {
        private Node<Item> progress = firstPointer;

        public boolean hasNext() {
            return progress != null;
        }

        public Item next() {
            if (progress == null) {
                throw new java.util.NoSuchElementException("No more elements remaining");

            }
            Item item = progress.item;
            progress = progress.next;
            return item;

        }

        public void remove() {
            throw new UnsupportedOperationException("womp womp");
        }


    }


    // unit testing (required)
    public static void main(String[] args) {
        Deque<String> deque = new Deque<String>();
        deque.addLast("Heheheha1");
        deque.addFirst("ha");
        deque.addLast("as");
        
        System.out.println("Deque size after operation, should be 3 -> " + deque.size());
        System.out.println("printing string, expect ha Heheheha1 as");
        for (String i : deque) {
            System.out.print(i + " ");
        }
        System.out.println();
        Deque<Integer> deque2 = new Deque<Integer>();
        deque2.addLast(5);
        deque2.addFirst(1);
        deque2.addFirst(2);
        deque2.addLast(3);
        deque2.addFirst(4);
        deque2.removeFirst();
        System.out.println(deque2.removeLast());
        
        
        
        
        System.out.println("expected size: , --> " + deque2.size());
        System.out.println("printing integers, ");
        for (Integer i : deque2) {
            System.out.print(i + " ");
        }
    

    }

    
    
}