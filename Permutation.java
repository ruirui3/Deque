import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author Rui Zhao attests that this code is their original work and was written in compliance with the class Academic Integrity and Collaboration Policy found in the syllabus. 
 */

 //Though I wouldn't say this is hard, solely due to it being basically a main command in deque or randomzied queue, I believe that the challenge of limiting to k is harder in randomized queue. I tried to work around this by when size reach k, you dequeue an element
 // then enqueue the next element while there were still strings to attach, but ultimately it failed and I am still wondering why that failed. Either way, this wasn't much of a challenge. 

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
