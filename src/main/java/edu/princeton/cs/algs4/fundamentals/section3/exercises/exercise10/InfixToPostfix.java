package edu.princeton.cs.algs4.fundamentals.section3.exercises.exercise10;

import edu.princeton.cs.algs4.fundamentals.section3.Stack;
import edu.princeton.cs.algs4.util.StdIn;
import edu.princeton.cs.algs4.util.StdOut;

public class InfixToPostfix {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        while (StdIn.isEmpty()) {
            String s = StdIn.readString();
            switch (s) {
                case "+":
                    stack.push(s);
                    break;
                case "*":
                    stack.push(s);
                    break;
                case ")":
                    StdOut.print(stack.pop() + " ");
                    break;
                case "(":
                    StdOut.print("");
                    break;
                default:
                    StdOut.print(s + " ");
                    break;
            }
        }
        StdOut.println();
    }
}
