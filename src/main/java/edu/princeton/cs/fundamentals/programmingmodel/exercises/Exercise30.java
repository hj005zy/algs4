package edu.princeton.cs.fundamentals.programmingmodel.exercises;

public class Exercise30 {

    public static int gcd(int p, int q) {
        return q == 0 ? p : gcd(q, p % q);
    }

    public static void main(String[] args) {
        int n = Integer.valueOf(args[0]);

        boolean[][] a = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    a[i][j] = true;
                } else {
                    a[i][j] = gcd(i, j) == 1;
                }
            }
        }
    }
}
