package edu.princeton.cs.algs4.fundamentals.section4.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.princeton.cs.algs4.util.In;
import edu.princeton.cs.algs4.util.StdIn;
import edu.princeton.cs.algs4.util.StdOut;

public class FibonacciSearch {

    public static int[] generateFib(int n) {

        List<Integer> fib = new ArrayList<>();
        fib.add(0);
        fib.add(1);
        fib.add(1);
        for (int i = 2; fib.get(i) < n; i++) {
            fib.add(fib.get(i - 1) + fib.get(i));
        }

        return fib.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int indexOf(int[] a, int[] fib, int key) {

        // Set k = m
        int k = fib[fib.length - 1] > a.length ? fib.length - 1 : fib.length;
        int offset = 0;

        // If k = 0, stop.
        // There is no match; the item is not in the array.
        while (k > 0) {
            int i = Math.min(offset + fib[--k], a.length - 1);
            // Compare the item against element in Fk−1
            if (key < a[i]) {
                // If the item is less than entry Fk−1, discard the elements from positions Fk−1 + 1 to n.
                // Set k = k − 1
                continue;
            } else if (key > a[i]) {
                // If the item is greater than entry Fk−1, discard the elements from positions 1 to Fk−1.
                // Renumber the remaining elements from 1 to Fk−2, set k = k − 2
                offset = i;
                k--;
            } else {
                // If the item matches, stop.
                return i;
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

        // n = Fm is the array size.
        // If n is not a Fibonacci number, the smallest number in F
        // that is greater than n
        int[] fib = generateFib(whitelist.length);

        // read integer key from standard input; print if not in whitelist
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (indexOf(whitelist, fib, key) == -1) {
                StdOut.println(key);
            }
        }
    }
}
