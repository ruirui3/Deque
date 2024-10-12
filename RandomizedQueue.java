public class RandomizedQueue<Item> implements Iterable<Item> {

    private Node<Item> first;
    private int randomQueueSize = 0;
    private Node<Item> last;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
        private Node<Item> previous;
        
    }


    // construct an empty randomized queue
    public RandomizedQueue() {
        first = null;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return randomQueueSize == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return randomQueueSize;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("null arg");
        }
        randomQueueSize++;
        Node<Item> oldLast = last;
        last = new Node<Item>();
        last.item = item;
        last.previous = oldLast;
        if (size() == 1) {
            first = last;
        } else {
            oldLast.next = last;
        }
    }

    // remove and return a random item
    public Item dequeue() {
        if (size()==0) {
            throw new java.util.NoSuchElementException("empty list already");
            
        }
    }

    // return a random item (but do not remove it)
    public Item sample() {

    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {

    }

    // unit testing (required)
    public static void main(String[] args) {

    }

}