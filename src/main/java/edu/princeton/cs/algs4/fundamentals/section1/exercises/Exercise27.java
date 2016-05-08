package edu.princeton.cs.algs4.fundamentals.section1.exercises;

import edu.princeton.cs.algs4.util.StdOut;

public class Exercise27 {

    // slow
    public static double binomial1(int n, int k, double p) {
        if (n == 0 && k == 0) {
            return 1.0;
        }
        if (n < 0 || k < 0) {
            return 0.0;
        }
        return (1.0 - p) * binomial1(n - 1, k, p) + p * binomial1(n - 1, k - 1, p);
    }

    // memoization
    public static double binomial2(int n, int k, double p) {
        double[][] b = new double[n + 1][k + 1];

        // base cases
        for (int i = 0; i <= n; i++) {
            b[i][0] = Math.pow(1.0 - p, i);
        }
        b[0][0] = 1.0;

        // recursive formula
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                b[i][j] = p * b[i - 1][j - 1] + (1.0 - p) * b[i - 1][j];
            }
        }
        return b[n][k];
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        double p = Double.parseDouble(args[2]);
        StdOut.println(binomial1(n, k, p));
        StdOut.println(binomial2(n, k, p));
    }
}
