package edu.princeton.cs.algs4.fundamentals.section2.exercises;

import edu.princeton.cs.algs4.fundamentals.section2.Interval1D;
import edu.princeton.cs.algs4.util.StdIn;
import edu.princeton.cs.algs4.util.StdOut;

public class Exercise02 {

    public static void printIntersectedIntervals(int N) {
        Interval1D[] intervals = new Interval1D[N];
        for (int i = 0; i < N; i++) {
            double left = StdIn.readDouble();
            double right = StdIn.readDouble();
            intervals[i] = new Interval1D(left, right);
        }
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (intervals[i].intersects(intervals[j])) {
                    StdOut.println("Interval" + intervals[i] + " intersect interval" + intervals[j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);

        printIntersectedIntervals(N);
    }
}
