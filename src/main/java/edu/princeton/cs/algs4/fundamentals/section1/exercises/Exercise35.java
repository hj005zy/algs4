package edu.princeton.cs.algs4.fundamentals.section1.exercises;

import edu.princeton.cs.algs4.util.StdOut;
import edu.princeton.cs.algs4.util.StdRandom;

public class Exercise35 {

    private static int SIDES = 6;

    public static double[] getDiceSumProbability() {
        double[] dist = new double[2 * SIDES + 1];

        for (int i = 1; i <= SIDES; i++) {
            for (int j = 1; j <= SIDES; j++) {
                dist[i + j] += 1.0;
            }
        }

        for (int k = 2; k <= 2 * SIDES; k++) {
            dist[k] /= SIDES * SIDES;
        }

        return dist;
    }

    public static double[] throwDice(int n) {
        double[] dist = new double[2 * SIDES + 1];

        for (int i = 0; i < n; i++) {
            dist[throwDice()]++;
        }

        for (int k = 2; k <= 2 * SIDES; k++) {
            dist[k] /= n;
        }

        return dist;
    }

    public static int throwDice() {
        return StdRandom.uniform(1, SIDES + 1) + StdRandom.uniform(1, SIDES + 1);
    }

    public static void main(String[] args) {
        int n = Integer.valueOf(args[0]);

        double[] probability = getDiceSumProbability();
        for (int i = 2; i <= 2 * SIDES; i++) {
            StdOut.printf("%7d", i);
        }
        StdOut.println();

        for (int i = 2; i <= 2 * SIDES; i++) {
            StdOut.printf("%7.3f", probability[i]);
        }
        StdOut.println();

        double[] throwDiceResult = throwDice(n);

        for (int i = 2; i <= 2 * SIDES; i++) {
            StdOut.printf("%7.3f", throwDiceResult[i]);
        }
        StdOut.println();
    }
}
