package edu.princeton.cs.algs4.fundamentals.section3.exercises.exercise19;

import edu.princeton.cs.algs4.fundamentals.section3.exercises.Node;
import edu.princeton.cs.algs4.util.StdOut;

public class Exercise19 {

    /*
     * Delete last node.
     */
    public static <Item> Node<Item> deleteLastNode(Node<Item> list) {
        if (list == null || list.getNext() == null) {
            return null;
        }

        Node<Item> cur = null;
        Node<Item> prev = null;
        for (cur = list.getNext(), prev = list; cur.getNext() != null; prev = cur, cur = cur.getNext()) {
        }
        prev.setNext(null);
        return list;
    }

    public static void main(String[] args) {
        Node<Integer> list = Node.createLinkedList(1, 2, 3);
        list = deleteLastNode(list);
        for (Node<Integer> cur = list; cur != null; cur = cur.getNext()) {
            StdOut.println(cur.getItem());
        }
    }
}
