package edu.princeton.cs.algs4.fundamentals.section4.exercises;

import java.io.IOException;

import edu.princeton.cs.algs4.util.StdIn;
import edu.princeton.cs.algs4.util.StdOut;
import edu.princeton.cs.algs4.util.StdRandom;

public class BitonicSearch {

    // create a bitonic array of size N
    public static int[] createBitonicArray(int n) {
        int mid = StdRandom.uniform(n);
        int[] a = new int[n];
        for (int i = 1; i < mid; i++) {
            a[i] = a[i - 1] + 1 + StdRandom.uniform(9);
        }

        if (mid > 0) {
            a[mid] = a[mid - 1] + StdRandom.uniform(10) - 5;
        }

        for (int i = mid + 1; i < n; i++) {
            a[i] = a[i - 1] - 1 - StdRandom.uniform(9);
        }

        for (int i = 0; i < n; i++) {
            StdOut.println(a[i]);
        }
        return a;
    }

    // find the index of the maximum in a bitonic subarray a[lo..hi]
    public static int findMax(int[] a) {
        int low = 0;
        int high = a.length;

        while (low < high) {
            int mid = (low + high) / 2;
            if (a[mid] < a[mid + 1]) {
                low = mid + 1;
            } else if (a[mid] > a[mid + 1]) {
                high = mid;
            } else {
                return mid;
            }
        }
        return high;
    }

    public static int indexOf(int[] a, int key) {
        int maxIndex = findMax(a);
        int result = indexOf(a, 0, maxIndex + 1, key, false);
        if (result < 0) {
            result = indexOf(a, maxIndex + 1, a.length, key, true);
        }
        return result;
    }

    private static int indexOf(int[] a, int start, int end, int key, boolean reverseOrder) {
        int lo = start;
        int hi = end - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                if (reverseOrder) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else if (key > a[mid]) {
                if (reverseOrder) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {

        int[] a = createBitonicArray(100);

        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            StdOut.println(indexOf(a, key));
        }
    }
}
