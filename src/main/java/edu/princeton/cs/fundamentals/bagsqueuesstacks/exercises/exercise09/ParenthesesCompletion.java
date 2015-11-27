package edu.princeton.cs.fundamentals.bagsqueuesstacks.exercises.exercise09;

import edu.princeton.cs.fundamentals.bagsqueuesstacks.Stack;
import edu.princeton.cs.util.StdIn;
import edu.princeton.cs.util.StdOut;

public class ParenthesesCompletion {

    public static String completeParentheses(String expression) {
        Stack<Character> operators = new Stack<>();
        Stack<String> operands = new Stack<>();

        for (char ch : expression.toCharArray()) {
            switch (ch) {
                case '+':
                case '-':
                case '*':
                case '/':
                    operators.push(ch);
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    operands.push(String.valueOf(ch));
                    break;
                case ')':
                    String operand1 = operands.pop();
                    String operand2 = operands.pop();
                    char operator = operators.pop();

                    StringBuilder operandsBuilder = new StringBuilder(5);
                    operandsBuilder.append("(").append(operand2).append(operator).append(operand1).append(")");

                    operands.push(operandsBuilder.toString());
                    break;
                case ' ':
                default:
                    break;
            }
        }

        return operands.pop();
    }

    public static void main(String[] args) {
        String expression = StdIn.readAll();
        StdOut.println(completeParentheses(expression));
    }
}
