package edu.princeton.cs.fundamentals.bagsqueuesstacks.exercises.exercise19;

public class Node<Item> {

    private Item item;

    private Node next;

    /*
     * Delete last node.
     */
    public static <T> void deleteLastNode(Node<T> first) {
        if (first == null) {
            return;
        }
        if (first.next == null) {
            first.item = null;
            return;
        }
        Node cur = null;
        Node prev = null;
        for (cur = first.next, prev = first; cur.next != null; prev = cur, cur = cur.next) {
        }
        prev.next = null;
    }
}
