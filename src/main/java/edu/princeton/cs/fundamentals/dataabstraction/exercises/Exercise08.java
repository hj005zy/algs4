package edu.princeton.cs.fundamentals.dataabstraction.exercises;

import edu.princeton.cs.fundamentals.dataabstraction.Counter;
import edu.princeton.cs.util.In;
import edu.princeton.cs.util.StdIn;
import edu.princeton.cs.util.StdOut;

import java.util.Arrays;

public class Exercise08 {

    public static int indexOf(int[] a, int key, Counter counter) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            counter.increment();
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        // read the integers from a file
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();

        // sort the array
        Arrays.sort(whitelist);

        // read integer key from standard input; print if not in whitelist
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            Counter counter = new Counter("BinarySearch");
            indexOf(whitelist, key, counter);
            StdOut.println("The total number of keys examined is " + counter.tally());
        }
    }
}
