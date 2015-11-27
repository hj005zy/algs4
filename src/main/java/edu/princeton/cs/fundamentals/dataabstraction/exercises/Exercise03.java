package edu.princeton.cs.fundamentals.dataabstraction.exercises;

import edu.princeton.cs.fundamentals.dataabstraction.Interval1D;
import edu.princeton.cs.fundamentals.dataabstraction.Interval2D;
import edu.princeton.cs.util.StdOut;
import edu.princeton.cs.util.StdRandom;

public class Exercise03 {

    public static void calculateIntersectedAndContainedIntervals(int N, int min, int max) {
        Interval2D[] intervals = new Interval2D[N];
        for (int i = 0; i < N; i++) {
            Interval1D x = createInterval1D(min, max);
            Interval1D y = createInterval1D(min, max);
            intervals[i] = new Interval2D(x, y);
        }
        int intersectedIntervalsCount = 0;
        int containedIntervalsCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (intervals[i].intersects(intervals[j])) {
                    intersectedIntervalsCount++;
                }
                if (intervals[i].contains(intervals[j]) || intervals[j].contains(intervals[i])) {
                    containedIntervalsCount++;
                }
            }
        }
        StdOut.println("The number of pairs of intervals that intersect is " + intersectedIntervalsCount);
        StdOut.println("The number of intervals that are contained in one another is " + containedIntervalsCount);
    }

    private static Interval1D createInterval1D(int min, int max) {
        double a;
        double b;
        do {
            a = StdRandom.uniform(min, max);
            b = StdRandom.uniform(min, max);
        } while (a == b);

        return new Interval1D(Math.min(a, b), Math.max(a, b));
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int min = Integer.parseInt(args[1]);
        int max = Integer.parseInt(args[2]);

        calculateIntersectedAndContainedIntervals(N, min, max);
    }
}
