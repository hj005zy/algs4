package edu.princeton.cs.algs4.fundamentals.section1.exercises;

import java.util.Arrays;

import edu.princeton.cs.algs4.util.In;
import edu.princeton.cs.algs4.util.StdIn;
import edu.princeton.cs.algs4.util.StdOut;

public class Exercise23 {

    public static int indexOf(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
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

        String operation = args[1];
        while (StdIn.isEmpty()) {
            int key = StdIn.readInt();
            int index = indexOf(whitelist, key);
            if (index != -1 && "-".equals(operation)) {
                StdOut.println(key);
            } else if (index == -1 && "+".equals(operation)) {
                StdOut.println(key);
            }
        }
    }
}
