package edu.princeton.cs.fundamentals.dataabstraction.exercises;

import edu.princeton.cs.util.StdOut;

public class Exercise06 {

    public static boolean isCircularRotation(String s1, String s2) {
        return s1.length() == s2.length() && (s1 + s1).indexOf(s2) >= 0;
    }

    public static void main(String[] args) {
        String s1 = args[0];
        String s2 = args[1];

        StdOut.println(isCircularRotation(s1, s2));
    }
}
