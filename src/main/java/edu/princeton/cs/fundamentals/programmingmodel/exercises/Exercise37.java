package edu.princeton.cs.fundamentals.programmingmodel.exercises;

import edu.princeton.cs.util.StdOut;
import edu.princeton.cs.util.StdRandom;

public class Exercise37 {

    public static void shuffleTest(int m, int n) {
        int[][] s = new int[m][m];

        for (int k = 0; k < n; k++) {
            int[] a = new int[m];
            for (int i = 0; i < m; i++) {
                a[i] = i;
            }
            badShuffle(a);

            for (int i = 0; i < m; i++) {
                s[i][a[i]]++;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                StdOut.printf("%7d", s[i][j]);
            }
            StdOut.println();
        }
    }

    public static void badShuffle(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int r = StdRandom.uniform(N);     // between 0 and N-1
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static void main(String[] args) {
        int m = Integer.valueOf(args[0]);
        int n = Integer.valueOf(args[1]);

        shuffleTest(m, n);
    }
}
