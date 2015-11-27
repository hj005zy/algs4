package edu.princeton.cs.fundamentals.programmingmodel.exercises;

import edu.princeton.cs.util.StdDraw;
import edu.princeton.cs.util.StdRandom;

import java.awt.*;
import java.awt.geom.Point2D;

public class Exercise31 {

    public static void drawRandomConnections(int n, double p) {
        StdDraw.setPenRadius(.05);
        double radian = 2 * Math.PI / n;
        double rotatedRadian = 0.0;
        Point2D.Double[] points = new Point2D.Double[n];
        for (int i = 0; i < n; i++) {
            double x = 0.5 + Math.sin(rotatedRadian) * .45;
            double y = 0.5 + Math.cos(rotatedRadian) * .45;
            rotatedRadian += radian;
            StdDraw.point(x, y);
            points[i] = new Point2D.Double(x, y);
        }

        StdDraw.setPenRadius();
        StdDraw.setPenColor(Color.GRAY);
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (StdRandom.bernoulli(p)) {
                    StdDraw.line(points[i].getX(), points[i].getY(), points[j].getX(), points[j].getY());
                }
            }
        }
    }

    public static void main(String[] args) {
        // number of dots
        int n = Integer.valueOf(args[0]);
        // 0 < p < 1
        double p = Double.valueOf(args[1]);

        drawRandomConnections(n, p);
    }
}
