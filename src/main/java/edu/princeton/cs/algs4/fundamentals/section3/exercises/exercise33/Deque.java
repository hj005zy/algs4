package edu.princeton.cs.algs4.fundamentals.section3.exercises.exercise33;

import edu.princeton.cs.algs4.fundamentals.section3.exercises.exercise31.DoublyLinkedList;

public class Deque<Item> {

    private DoublyLinkedList<Item> list;

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public void pushLeft(Item item) {
        list.insertFirst(item);
    }

    public void pushRight(Item item) {
        list.insertLast(item);
    }

    public Item popLeft() {
        return list.removeFirst();
    }

    public Item popRight() {
        return list.removeLast();
    }
}
