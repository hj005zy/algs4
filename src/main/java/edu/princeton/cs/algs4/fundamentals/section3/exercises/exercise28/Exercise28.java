package edu.princeton.cs.algs4.fundamentals.section3.exercises.exercise28;

import edu.princeton.cs.algs4.fundamentals.section3.exercises.Node;
import edu.princeton.cs.algs4.util.StdOut;

public class Exercise28 {

    public static Integer max(Node<Integer> list, int max) {
        if (list == null) {
            return max;
        }

        return max(list.getNext(), Math.max(list.getItem(), max));
    }

    public static void main(String[] args) {
        Node<Integer> list = Node.createLinkedList(34, 22, 95, 20, 49, 83, 73);
        StdOut.println(max(list, Integer.MIN_VALUE));
    }
}
