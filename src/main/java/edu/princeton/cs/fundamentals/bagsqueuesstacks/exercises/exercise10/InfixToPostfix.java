package edu.princeton.cs.fundamentals.bagsqueuesstacks.exercises.exercise10;

/******************************************************************************
 * Compilation:  javac InfixToPostfix.java
 * Execution:    java InfixToPostFix
 * Dependencies: Stack.java StdIn.java StdOut.java
 *
 * Reads in an infix expression and outputs an equivalent postfix
 * expression.
 *
 * Windows users: replace [Ctrl-d] with [Ctrl-z] to signify end of file.
 *
 * % java InfixToPostfix
 * ( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )
 * [Ctrl-d]
 * 2 3 4 + 5 6 * * +
 *
 * % java InfixToPostfix | java EvaluatePostfix
 * ( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )
 * [Ctrl-d]
 * 212
 ******************************************************************************/

import edu.princeton.cs.fundamentals.bagsqueuesstacks.Stack;
import edu.princeton.cs.util.StdIn;
import edu.princeton.cs.util.StdOut;

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
