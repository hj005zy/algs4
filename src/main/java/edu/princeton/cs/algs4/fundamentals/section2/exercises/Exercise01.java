package edu.princeton.cs.algs4.fundamentals.section2.exercises;

import edu.princeton.cs.algs4.fundamentals.section2.Point2D;
import edu.princeton.cs.algs4.util.StdDraw;
import edu.princeton.cs.algs4.util.StdOut;
import edu.princeton.cs.algs4.util.StdRandom;

public class Exercise01 {

    public static void drawPoints(int N) {
        int size = 10000;

        StdDraw.setScale(0, size);
        StdDraw.square(size / 2, size / 2, size / 4);

        Point2D[] points = new Point2D[N];
        for (int i = 0; i < N; i++) {
            double x = StdRandom.uniform(size / 4, size / 4 * 3);
            double y = StdRandom.uniform(size / 4, size / 4 * 3);
            Point2D p = new Point2D(x, y);
            p.draw();

            points[i] = p;
        }

        double minDistance = Double.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                minDistance = Math.min(minDistance, points[i].distanceTo(points[j]));
            }
        }
        StdOut.printf("The distance seperating the closest pair of points is %.2f", minDistance);
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);

        drawPoints(N);
    }
}
