package edu.princeton.cs.algs4.fundamentals.section4.exercises;

import edu.princeton.cs.algs4.util.StdOut;

public class MatrixLocalMin {

    private static int[] searchLocalMin(int[][] matrix) {
        int row = matrix.length;
        if (row == 1 && matrix[0].length == 1) {
            return new int[] { 0, 0 };
        }
        int col = matrix[0].length;
        if (matrix[0][0] < matrix[0][1] && matrix[0][0] < matrix[1][0]) {
            return new int[] { 0, 0 };
        }
        if (matrix[0][col - 1] < matrix[0][col - 2] && matrix[0][col - 1] < matrix[1][col - 1]) {
            return new int[] { 0, col - 1 };
        }
        if (matrix[row - 1][0] < matrix[row - 2][0] && matrix[row - 1][0] < matrix[row - 1][1]) {
            return new int[] { row - 1, 0 };
        }
        if (matrix[row - 1][col - 1] < matrix[row - 2][col - 1] && matrix[row - 1][col - 1] < matrix[row - 1][col - 2]) {
            return new int[] { row - 1, col - 1 };
        }
        int rowLow = 0;
        int rowHigh = row - 1;
        int rowIndex = (rowLow + rowHigh) / 2;
        int colLow = 0;
        int colHigh = col - 1;
        while (rowLow < rowHigh) {
            int colIndex = findSmallestInRow(matrix[rowIndex], colLow, colHigh);
            int localMin = matrix[rowIndex][colIndex];
            if (rowIndex == 0 && localMin < matrix[rowIndex + 1][colIndex]) {
                return new int[] { rowIndex, colIndex };
            } else if (rowIndex == row - 1 && localMin < matrix[row - 2][colIndex]) {
                return new int[] { rowIndex, colIndex };
            } else if (localMin < matrix[rowIndex - 1][colIndex] && localMin < matrix[rowIndex + 1][colIndex]) {
                return new int[] { rowIndex, colIndex };
            } else if (localMin < matrix[rowIndex - 1][colIndex] && localMin > matrix[rowIndex + 1][colIndex]) {
                rowLow = rowIndex + 1;
            } else if (localMin > matrix[rowIndex - 1][colIndex] && localMin > matrix[rowIndex + 1][colIndex]) {
                rowLow = rowIndex + 1;
            } else {
                rowHigh = rowIndex - 1;
            }
            rowIndex = findSmallestInColumn(matrix, colIndex, rowLow, rowHigh);
            localMin = matrix[rowIndex][colIndex];
            if (colIndex == 0 && localMin < matrix[rowIndex][colIndex + 1]) {
                return new int[] { rowIndex, colIndex };
            } else if (colIndex == col - 1 && localMin < matrix[rowIndex][col - 2]) {
                return new int[] { rowIndex, colIndex };
            } else if (localMin < matrix[rowIndex][colIndex - 1] && localMin < matrix[rowIndex][colIndex + 1]) {
                return new int[] { rowIndex, colIndex };
            }
        }
        return new int[] { -1, -1 };
    }

    private static int findSmallestInRow(int[] a, int start, int end) {
        int result = -1;
        int smallest = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            if (a[i] < smallest) {
                smallest = a[i];
                result = i;
            }
        }
        return result;
    }

    private static int findSmallestInColumn(int[][] matrix, int colIndex, int start, int end) {
        int result = -1;
        int smallest = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            if (matrix[i][colIndex] < smallest) {
                smallest = matrix[i][colIndex];
                result = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 11, 12, 3, 1, 4 }, { 7, 9, 8, 5, 6 }, { 4, 5, 13, -1, 77 }, { 15, 0, 35, -2, -4 },
                { 16, 83, -6, -5, -3 } };
        StdOut.println(searchLocalMin(matrix));
    }
}
