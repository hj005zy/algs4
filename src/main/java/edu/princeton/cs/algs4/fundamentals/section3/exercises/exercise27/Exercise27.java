package edu.princeton.cs.algs4.fundamentals.section3.exercises.exercise27;

import edu.princeton.cs.algs4.fundamentals.section3.exercises.Node;
import edu.princeton.cs.algs4.util.StdOut;

public class Exercise27 {

    public static Integer max(Node<Integer> list) {
        if (list == null) {
            return null;
        }

        int max = Integer.MIN_VALUE;
        for (Node<Integer> cur = list; cur != null; cur = cur.getNext()) {
            Integer item = cur.getItem();
            if (item != null) {
                max = Math.max(max, item);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Node<Integer> list = Node.createLinkedList(34, 22, 95, 20, 49, 83, 73);
        StdOut.println(max(list));
    }
}
