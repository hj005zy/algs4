package edu.princeton.cs.fundamentals.programmingmodel.exercises;

import java.util.Arrays;

import edu.princeton.cs.util.In;
import edu.princeton.cs.util.StdIn;
import edu.princeton.cs.util.StdOut;

public class Exercise22 {

    public static int indexOf(int[] a, int key) {
        return indexOf(a, key, 0, a.length, 0);
    }

    private static int indexOf(int[] a, int key, int lo, int hi, int depth) {
        for (int i = 0; i < depth; i++) {
            StdOut.print("  ");
        }
        StdOut.println("low: " + lo + ", high: " + hi);
        if (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
            return indexOf(a, key, lo, hi, depth + 1);
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
        while (StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (indexOf(whitelist, 0) == -1) {
                StdOut.println(key);
            }
        }
    }
}
