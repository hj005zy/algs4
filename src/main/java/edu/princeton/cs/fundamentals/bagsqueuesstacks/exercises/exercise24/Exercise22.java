package edu.princeton.cs.fundamentals.bagsqueuesstacks.exercises.exercise24;

import edu.princeton.cs.fundamentals.bagsqueuesstacks.exercises.Node;
import edu.princeton.cs.util.StdOut;

public class Exercise22 {

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
