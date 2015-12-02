package edu.princeton.cs.fundamentals.bagsqueuesstacks.exercises.exercise20;

import edu.princeton.cs.fundamentals.bagsqueuesstacks.exercises.Node;
import edu.princeton.cs.util.StdOut;

public class Exercise20 {

    public static <Item> Node<Item> delete(Node<Item> list, int k) {
        assert k > 0;
        Node<Item> cur = null;
        Node<Item> prev = null;
        int i = 1;
        for (cur = list; i != k && cur != null; prev = cur, cur = cur.getNext()) {
            i++;
        }
        if (i == k && cur != null) {
            if (prev == null) {
                list = list.getNext();
            } else {
                prev.setNext(cur.getNext());
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Node<Integer> list = Node.createLinkedList(1, 2, 3);
        list = delete(list, 6);
        for (Node<Integer> cur = list; cur != null; cur = cur.getNext()) {
            StdOut.println(cur.getItem());
        }
    }
}
