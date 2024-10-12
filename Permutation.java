import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Permutation {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        RandomizedQueue<String> r = new RandomizedQueue<String>();
        
        while (!StdIn.isEmpty()) {
            r.enqueue(StdIn.readString());
        }

        while (n > 0) {
            n--;
            System.out.println(r.dequeue());
        }


    }
}
