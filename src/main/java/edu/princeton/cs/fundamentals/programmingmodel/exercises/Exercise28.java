package edu.princeton.cs.fundamentals.programmingmodel.exercises;

import edu.princeton.cs.fundamentals.programmingmodel.BinarySearch;
import edu.princeton.cs.util.In;
import edu.princeton.cs.util.StdIn;
import edu.princeton.cs.util.StdOut;

import java.util.Arrays;

public class Exercise28 {

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

    private static int[] removeDuplicates(int[] a) {

        int[] result = {};
        int i = 0;
        for (int n : a) {
            if (indexOf(result, n) == -1) {
                result = Arrays.copyOf(result, result.length + 1);
                result[i++] = n;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        // read the integers from a file
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();

        // sort the array
        Arrays.sort(whitelist);
        // remove duplicates
        whitelist = removeDuplicates(whitelist);

        // read integer key from standard input; print if not in whitelist
        while (StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (BinarySearch.indexOf(whitelist, key) == -1) {
                StdOut.println(key);
            }
        }
    }
}
