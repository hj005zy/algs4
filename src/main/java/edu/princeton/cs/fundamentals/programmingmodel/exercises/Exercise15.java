package edu.princeton.cs.fundamentals.programmingmodel.exercises;

import java.util.Arrays;

public class Exercise15 {

    public static int[] histogram(int[] a, int m) {
        int[] result = new int[m];
        Arrays.fill(result, 0);

        for (int i = 0; i < m; i++) {
            for (int n : a) {
                if (n == i) {
                    result[i] = result[i] + 1;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5 };
        int[] histogram = histogram(a, 6);
        for (int n : histogram) {
            System.out.println(n);
        }
    }
}
