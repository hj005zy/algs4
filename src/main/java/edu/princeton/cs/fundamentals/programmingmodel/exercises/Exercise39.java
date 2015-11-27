package edu.princeton.cs.fundamentals.programmingmodel.exercises;

import edu.princeton.cs.fundamentals.programmingmodel.BinarySearch;
import edu.princeton.cs.util.StdOut;
import edu.princeton.cs.util.StdRandom;

import java.util.Arrays;

public class Exercise39 {

    public static void caculate(int t, int n) {

        long count = 0;
        for (int i = 0; i < t; i++) {
            count += count(n);
        }

        double average = (double) count / t;

        StdOut.printf("%8d: %9.2f\n", n, average);
    }

    public static long count(int n) {
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniform(100000, 1000000);
            b[i] = StdRandom.uniform(100000, 1000000);
        }

        Arrays.sort(a);

        long count = 0;
        for (int i = 0; i < n; i++) {
            if (BinarySearch.indexOf(a, b[i]) >= 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int t = Integer.valueOf(args[0]);

        int[] ns = {1000, 10000, 100000, 1000000};
        for (int n : ns) {
            caculate(t, n);
        }
    }
}
