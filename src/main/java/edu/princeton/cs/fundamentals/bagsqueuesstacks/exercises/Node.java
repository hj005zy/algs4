package edu.princeton.cs.fundamentals.bagsqueuesstacks.exercises;

public class Node<Item> {

    private Item item;

    private Node<Item> next;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Node<Item> getNext() {
        return next;
    }

    public void setNext(Node<Item> next) {
        this.next = next;
    }

    @SafeVarargs
    public static <Item> Node<Item> createLinkedList(Item... items) {
        Node<Item> head = null;
        Node<Item> next = null;
        Node<Item> cur = null;
        for (Item item : items) {
            if (head == null) {
                head = new Node<>();
                head.setItem(item);
                cur = head;
            } else {
                next = new Node<>();
                next.setItem(item);
                cur.setNext(next);
                cur = next;
            }
        }
        return head;
    }
}
