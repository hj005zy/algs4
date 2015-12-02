package edu.princeton.cs.fundamentals.bagsqueuesstacks.exercises.exercise25;

import edu.princeton.cs.fundamentals.bagsqueuesstacks.exercises.Node;
import edu.princeton.cs.util.StdOut;

public class Exercise25<Item> {

    public static <Item> void insertAfter(Node<Item> list, Node<Item> node) {
        if (list == null || node == null) {
            return;
        }

        node.setNext(list.getNext());
        list.setNext(node);
    }

    public static void main(String[] args) {
        Node<Integer> list = Node.createLinkedList(1, 2, 3);
        Node<Integer> node = new Node<>();
        node.setItem(10);
        insertAfter(list, node);
        for (Node<Integer> cur = list; cur != null; cur = cur.getNext()) {
            StdOut.println(cur.getItem());
        }
    }
}
