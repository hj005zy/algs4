package edu.princeton.cs.fundamentals.bagsqueuesstacks.exercises.exercise26;

import edu.princeton.cs.fundamentals.bagsqueuesstacks.exercises.Node;
import edu.princeton.cs.util.StdOut;

import java.util.Objects;

public class Exercise26 {

    public static <Item> Node<Item> remove(Node<Item> list, Item key) {
        if (list == null) {
            return list;
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
