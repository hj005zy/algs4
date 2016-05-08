package edu.princeton.cs.algs4.fundamentals.section3.exercises.exercise04;

import edu.princeton.cs.algs4.fundamentals.section3.Stack;
import edu.princeton.cs.algs4.util.StdIn;
import edu.princeton.cs.algs4.util.StdOut;

public class Parentheses {

    private static final char LEFT_PAREN = '(';

    private static final char RIGHT_PAREN = ')';

    private static final char LEFT_BRACE = '{';

    private static final char RIGHT_BRACE = '}';

    private static final char LEFT_BRACKET = '[';

    private static final char RIGHT_BRACKET = ']';

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            switch (ch) {
                case LEFT_PAREN:
                case LEFT_BRACE:
                case LEFT_BRACKET:
                    stack.push(ch);
                    break;
                case RIGHT_PAREN:
                    if (stack.isEmpty() || stack.pop() != LEFT_PAREN) {
                        return false;
                    }
                    break;
                case RIGHT_BRACE:
                    if (stack.isEmpty() || stack.pop() != LEFT_BRACE) {
                        return false;
                    }
                    break;
                case RIGHT_BRACKET:
                    if (stack.isEmpty() || stack.pop() != LEFT_BRACKET) {
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = StdIn.readAll().trim();
        StdOut.println(isBalanced(s));
    }
}
