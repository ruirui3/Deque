import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

/**
 * @author Rui Zhao attests that this code is their original work and was written in compliance with the class Academic Integrity and Collaboration Policy found in the syllabus. 
 */

 //I think the hardest part about this class was the implementation of the iterator. I was confused on the conditions of the iterator, but after looking back at my apcsa notes I was able to debunk some of the uncertainties regarding swap and bounds. 
 //Also I think it was interesting that I thought casting was the primary error upon submission, even though I have watched the video. I was very close to scrapping this entirely and tried to come up with an approach similar to Deque.java using linkedlist instead
 //of [] because appearantly the video said java hates us and it is what it is. 

public class RandomizedQueue<Item> implements Iterable<Item> {

    

    private Item[] randomQueue;
    private int size = 0;
    


    // construct an empty randomized queue
    
    public RandomizedQueue() {
    
        randomQueue = (Item[]) new Object[2];
        


    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    private void resize(int afterSize) {
        Item[] newQueue = (Item[]) new Object[afterSize];
        for (int i = 0; i < size; i++) {
            newQueue[i] = randomQueue[i];
        }
        randomQueue = newQueue;
    }

    // add the item do the front
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("null arg");
        }

        if (size==randomQueue.length) {
            resize(size*2);
        }
        
        randomQueue[size++] = item;

        
    }

    private int fetchRandomIndex() {
        return StdRandom.uniformInt(0, size);
    }

    // remove and return a random item
    public Item dequeue() {
        if (size()==0) {
            throw new java.util.NoSuchElementException("empty list already");
        }
        int randomIndexRemove = fetchRandomIndex();
        Item item = randomQueue[randomIndexRemove];
        randomQueue[randomIndexRemove] = randomQueue[size-1];
        randomQueue[size-1] = null;
        size--;
        if (size>0 && size == randomQueue.length / 4) {
            resize(randomQueue.length / 2);
        }
        return item;



    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException("current queue is empty");
        }
        return randomQueue[fetchRandomIndex()];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomQueueIterator();
    }

    private class RandomQueueIterator implements Iterator<Item> {
        private int start;
        private int[] order;

        public RandomQueueIterator() {
            start = 0;
            order = new int[size];
            for (int i = 0; i<size; i++) {
                order[i]=i;
            }

            for (int i = 0; i< size; i++) {
                int random = i + StdRandom.uniformInt(size - i);
                //swap
                int temp = order[i];
                order[i] = order[random];
                order[random] = temp;
            }
        }

        public boolean hasNext() {
            return start < size;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("no more next");
            }
            return randomQueue[order[start++]]; //returns item at shuffled index (shuffled already by constructor, returns a random index of randomQueue)
            
        }

        public void remove() {
            throw new UnsupportedOperationException("womp womp");
        }


    }



    // unit testing (required)
    public static void main(String[] args) {
        
    }

}