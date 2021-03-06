package edu.princeton.cs.algs4.fundamentals.section3.exercises.exercise11;

import edu.princeton.cs.algs4.fundamentals.section3.Stack;
import edu.princeton.cs.algs4.util.StdIn;
import edu.princeton.cs.algs4.util.StdOut;

/******************************************************************************
 * Compilation:  javac EvaluatePostfix.java
 * Execution:    java EvaluatePostfix < file.txt
 * Dependencies: Stack.java StdIn.java StdOut.java
 *
 * Evaluates postfix expresions using a stack.
 *
 * Windows users: replace [Ctrl-d] with [Ctrl-z] to signify end of file.
 *
 * % java EvaluatePostfix
 * 3 4 5 + *
 * [Ctrl-d]
 * 27
 *
 * % java EvaluatePostfix
 * 1 2 3 4 5 * + 6 * * +
 * [Ctrl-d]
 * 277
 *
 * % java EvaluatePostfix
 * 7 16 16 16 * * * 5 16 16 * * 3 16 * 1 + + +
 * [Ctrl-d]
 * 30001
 *
 * % java EvaluatePostfix
 * 7 16 * 5 + 16 * 3 + 16 * 1 +
 * [Ctrl-d]
 * 30001
 *
 * Known bugs
 * ----------
 * - No error checking - assumes input is legal postfix expression.
 * - All token must be separated by whitespace, e.g., 1 5+ is illegal.
 ******************************************************************************/
public class EvaluatePostfix {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        while (StdIn.isEmpty()) {
            String s = StdIn.readString();
            switch (s) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                default:
                    stack.push(Integer.valueOf(s));
                    break;
            }
        }
        StdOut.println(stack.pop());
    }
}
