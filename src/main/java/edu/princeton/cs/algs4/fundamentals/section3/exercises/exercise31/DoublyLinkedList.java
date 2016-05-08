package edu.princeton.cs.algs4.fundamentals.section3.exercises.exercise31;

public class DoublyLinkedList<Item> {

    private static class DoubleNode<Item> {

        private Item item;

        private DoubleNode<Item> prev;

        private DoubleNode<Item> next;
    }

    private int N;

    private DoubleNode<Item> first;

    private DoubleNode<Item> last;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insertFirst(Item item) {
        DoubleNode<Item> node = new DoubleNode<>();
        node.item = item;

        if (N == 0) {
            first = last = node;
        } else {
            node.next = first;
            first.prev = node;
            first = node;
        }
        N++;
    }

    public void insertLast(Item item) {
        DoubleNode<Item> node = new DoubleNode<>();
        node.item = item;

        if (N == 0) {
            first = last = node;
        } else {
            last.next = node;
            node.prev = last;
            last = node;
        }
        N++;
    }

    public Item removeFirst() {
        if (N == 0) {
            return null;
        }

        Item item = first.item;
        if (N == 1) {
            first = last = null;
        } else {
            first = first.next;
            first.prev = null;
        }
        N--;

        return item;
    }

    public Item removeLast() {
        if (N == 0) {
            return null;
        }

        Item item = last.item;
        if (N == 1) {
            first = last = null;
        } else {
            last = last.prev;
            last.next = null;
        }
        N--;

        return item;
    }

    public void insertBefore(DoubleNode<Item> node, Item item) {
        DoubleNode<Item> newNode = new DoubleNode<>();
        newNode.item = item;

        newNode.next = node;
        newNode.prev = node.prev;
        node.prev = newNode;
        if (newNode.prev != null) {
            newNode.prev.next = newNode;
        }
        N++;
    }

    public void insertAfter(DoubleNode<Item> node, Item item) {
        DoubleNode<Item> newNode = new DoubleNode<>();
        newNode.item = item;

        newNode.prev = node;
        newNode.next = node.next;
        node.next = newNode;
        if (newNode.next != null) {
            newNode.next.prev = newNode;
        }
        N++;
    }

    public void remove(DoubleNode<Item> node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }

        N--;
    }
}
