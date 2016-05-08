package edu.princeton.cs.algs4.fundamentals.section1.exercises;

import edu.princeton.cs.algs4.util.StdIn;

public class Exercise24 {

    public static int gcd(int p, int q) {
        System.out.println("p:" + p + ", q:" + q);
        return q == 0 ? p : gcd(q, p % q);
    }

    public static void main(String[] args) {
        while (StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            System.out.println(gcd(p, q));
        }
    }
}
