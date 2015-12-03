package edu.princeton.cs.fundamentals.programmingmodel.exercises;

import edu.princeton.cs.util.In;
import edu.princeton.cs.util.StdIn;
import edu.princeton.cs.util.StdOut;

import java.util.Arrays;

public class Exercise29 {

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

    public static int rank(int[] a, int key) {
        int index = indexOf(a, key);
        if (index == -1 || a[0] == key) {
            return 0;
        }
        while (a[--index] == key && index >= 0) {
        }
        return index + 1;
    }

    public static int count(int[] a, int key) {
        int index = indexOf(a, key);
        if (index == -1) {
            return 0;
        }
        int count = 1;
        int previousIndex = index - 1;
        for (; previousIndex >= 0 && a[previousIndex] == key; previousIndex--, count++) {
        }
        int nextIndex = index + 1;
        for (; nextIndex < a.length && a[nextIndex] == key; nextIndex++, count++) {
        }

        return count;
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
            int rank = rank(whitelist, key);
            int count = count(whitelist, key);
            StdOut.println("Rank: " + rank + ", Count: " + count);
        }
    }
}
