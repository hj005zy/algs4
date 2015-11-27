package edu.princeton.cs.fundamentals.programmingmodel.exercises;

public class Exercise14 {

    public static int lg(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Please input positive number");
        }
        int result = 0;
        n /= 2;
        for (; n != 0; n /= 2, result++) {
            ;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(lg(23199831));
    }
}
