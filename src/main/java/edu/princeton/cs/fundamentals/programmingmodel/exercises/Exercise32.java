package edu.princeton.cs.fundamentals.programmingmodel.exercises;

import edu.princeton.cs.util.StdDraw;
import edu.princeton.cs.util.StdIn;
import edu.princeton.cs.util.StdStats;

public class Exercise32 {

    public static void histogram(double[] values, int n, double l, double r) {
        int[] counts = new int[n];

        for (double value : values) {
            int k = getInterval(value, n, l, r);
            if (k >= 0) {
                counts[k]++;
            }
        }

        int maxCount = StdStats.max(counts);

        StdDraw.setXscale(l, r);
        StdDraw.setYscale(0, maxCount);

        double w = (r - l) / n;

        for (int i = 0; i < n; i++) {
            double x = l + (i + 0.5) * w;
            double y = counts[i] / 2.0;
            double rw = 0.5 * w;
            double rh = counts[i] / 2.0;
            StdDraw.filledRectangle(x, y, rw, rh);
        }
    }

    private static int getInterval(double v, int n, double l, double r) {
        if (v < l || v >= r) {
            return -1;
        } else {
            return (int) (n * (v - l) / (r - l));
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double l = Double.parseDouble(args[1]);
        double r = Double.parseDouble(args[2]);

        double[] values = StdIn.readAllDoubles();

        histogram(values, n, l, r);
    }
}
