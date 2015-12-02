package edu.princeton.cs.fundamentals.bagsqueuesstacks.exercises.exercise21;

import edu.princeton.cs.fundamentals.bagsqueuesstacks.exercises.Node;
import edu.princeton.cs.util.StdOut;

import java.util.Objects;

public class Exercise21 {

    public static <Item> boolean find(Node<Item> list, Item key) {
        if (list == null) {
            return false;
        }

        for (Node<Item> cur = list; cur != null; cur = cur.getNext()) {
            if (Objects.equals(key, cur.getItem())) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node<Integer> list = Node.createLinkedList(1, 2, 3);
        StdOut.println(find(list, 2));
    }
}
