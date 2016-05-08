package edu.princeton.cs.algs4.fundamentals.section3.exercises.exercise26;

import java.util.Objects;

import edu.princeton.cs.algs4.fundamentals.section3.exercises.Node;
import edu.princeton.cs.algs4.util.StdOut;

public class Exercise26 {

    public static <Item> Node<Item> remove(Node<Item> list, Item key) {
        if (list == null) {
            return null;
        }

        Node<Item> head = list;
        Node<Item> cur = head;
        Node<Item> prev = null;
        while (cur != null) {
            if (Objects.equals(cur.getItem(), key)) {
                if (prev == null) {
                    head = head.getNext();
                } else {
                    prev.setNext(cur.getNext());
                }
            } else {
                prev = cur;
            }
            cur = cur.getNext();
        }

        return head;
    }

    public static void main(String[] args) {
        Node<Integer> list = Node.createLinkedList(1, 2, 1, 2, 3, 2, 3);
        list = remove(list, 1);
        for (Node<Integer> cur = list; cur != null; cur = cur.getNext()) {
            StdOut.println(cur.getItem());
        }
    }
}
