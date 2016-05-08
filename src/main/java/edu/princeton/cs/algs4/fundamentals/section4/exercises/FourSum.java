/******************************************************************************
 *  Compilation:  javac FourSum.java
 *  Execution:    java FourSum < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *
 *  A program with N^4 running time. Read in N long integers
 *  and counts the number of 4-tuples that sum to exactly 0.
 *
 *  Limitations
 *  -----------
 *     - we ignore integer overflow
 *
 ******************************************************************************/

package edu.princeton.cs.algs4.fundamentals.section4.exercises;

import edu.princeton.cs.algs4.util.In;
import edu.princeton.cs.algs4.util.StdOut;

public class FourSum {

    // print distinct 4-tuples (i, j, k, l) such that a[i] + a[j] + a[k] + a[l] = 0
    public static void printAll(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    for (int l = k + 1; l < N; l++) {
                        if (a[i] + a[j] + a[k] + a[l] == 0) {
                            StdOut.println(a[i] + " " + a[j] + " " + a[k] + " " + a[l]);
                        }
                    }
                }
            }
        }
    }

    // return number of distinct 4-tuples (i, j, k, l) such that a[i] + a[j] + a[k] + a[l] = 0
    public static int count(int[] a) {
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    for (int l = k + 1; l < N; l++) {
                        if (a[i] + a[j] + a[k] + a[l] == 0) {
                            cnt++;
                        }
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] a = in.readAllInts();

        int cnt = count(a);
        StdOut.println(cnt);
        if (cnt < 10) {
            printAll(a);
        }
    }
}
