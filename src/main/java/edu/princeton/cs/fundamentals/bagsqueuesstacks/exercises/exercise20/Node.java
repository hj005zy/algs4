package edu.princeton.cs.fundamentals.bagsqueuesstacks.exercises.exercise20;

public class Node<Item> {

    private Item item;

    private Node next;

    public void delete(int k) {
        assert k >= 0;
        Node cur = null;
        int i = 0;
        for (cur = this; i++ != k && cur != null; cur = cur.next) {
        }
        if (i == k && cur.next != null) {
            cur.next = cur.next.next;
        }
    }
}
