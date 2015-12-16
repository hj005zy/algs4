package edu.princeton.cs.fundamentals.bagsqueuesstacks.exercises.exercise38;

import edu.princeton.cs.fundamentals.bagsqueuesstacks.exercises.Node;

import java.util.NoSuchElementException;

public class LinkedGeneralizedQueue<Item> {

    private Node<Item> first;

    private Node<Item> last;

    // number of elements on queue
    private int N;

    public LinkedGeneralizedQueue() {
        first = null;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    /**
     * Adds the item to this queue.
     *
     * @param item the item to add
     */
    public void insert(Item item) {
        Node<Item> node = new Node<>();
        node.setItem(item);

        // add item
        if (isEmpty()) {
            first = last = node;
        } else {
            last.setNext(node);
            last = node;
        }
    }

    /**
     * Removes and returns the item on this queue that was kth least recently added.
     *
     * @return the item on this queue that was kth least recently added
     * @throws NoSuchElementException if this queue is empty
     */
    public Item delete(int k) {
        if (k > N) {
            throw new NoSuchElementException("Queue underflow");
        }
        Node<Item> cur = first;
        Node<Item> prev = null;
        for (int i = 1; i < k; i++) {
            prev = cur;
            cur = cur.getNext();
        }
        Item item = cur.getItem();
        if (prev == null) {
            first = last = null;
        } else {
            prev.setNext(cur.getNext());
        }
        return item;
    }
}
