package edu.princeton.cs.algs4.fundamentals.section1.exercises;

import java.util.Arrays;

public class Exercise33 {

    public static double dot(double[] x, double[] y) {
        double result = 0.0;
        for (int i = 0; i < x.length; i++) {
            result += x[i] * y[i];
        }
        return result;
    }

    public static double[][] mult(double[][] a, double[][] b) {
        int row = a.length;
        int column = b[0].length;

        double[][] result = new double[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                for (int k = 0; k < b.length; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }

    public static double[] mult(double[][] a, double[] x) {
        double[][] b = new double[x.length][1];
        for (int i = 0; i < x.length; i++) {
            b[i][0] = x[i];
        }
        double[][] product = mult(a, b);
        double[] result = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = product[i][0];
        }
        return result;
    }

    public static double[] mult(double[] x, double[][] a) {
        double[][] b = new double[][] { x };
        return mult(b, a)[0];
    }

    public static double[][] transpose(double[][] a) {
        int row = a[0].length;
        int column = a.length;

        double[][] transpose = new double[row][column];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                transpose[j][i] = a[i][j];
            }
        }
        return transpose;
    }

    public static void main(String[] args) {

        double[] x = { 1, 2, 3 };
        double[] y = { 4, 5, 6 };
        System.out.println(dot(x, y));

        double[][] a = { { 1, 2, 3 }, { 4, 5, 6 } };
        double[][] b = { { 1, 4 }, { 2, 5 }, { 3, 6 } };
        System.out.println(Arrays.deepToString(mult(a, b)));
        System.out.println(Arrays.deepToString(transpose(a)));

        System.out.println(Arrays.toString(mult(a, y)));
        System.out.println(Arrays.toString(mult(x, b)));
    }
}
