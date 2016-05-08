package edu.princeton.cs.algs4.fundamentals.section3.exercises.exercise24;

import edu.princeton.cs.algs4.fundamentals.section3.exercises.Node;
import edu.princeton.cs.algs4.util.StdOut;

public class Exercise24 {

    public static <Item> void removeAfter(Node<Item> list) {
        if (list == null || list.getNext() == null) {
            return;
        }

        list.setNext(list.getNext().getNext());
    }

    public static void main(String[] args) {
        Node<Integer> list = Node.createLinkedList(1, 2, 3);
        removeAfter(list);
        for (Node<Integer> cur = list; cur != null; cur = cur.getNext()) {
            StdOut.println(cur.getItem());
        }
    }
}
