package edu.princeton.cs.fundamentals.bagsqueuesstacks.exercises.exercise29;

import edu.princeton.cs.util.StdIn;
import edu.princeton.cs.util.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularLinkedQueue<Item> implements Iterable<Item> {

    private int N;

    private Node last;

    // helper linked list class
    private class Node {
        private Item item;

        private Node next;
    }

    /**
     * Initializes an empty queue.
     */
    public CircularLinkedQueue() {
        last = null;
        N = 0;
        assert check();
    }

    /**
     * Is this queue empty?
     *
     * @return true if this queue is empty; false otherwise
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * Returns the number of items in this queue.
     *
     * @return the number of items in this queue
     */
    public int size() {
        return N;
    }

    /**
     * Returns the item least recently added to this queue.
     *
     * @return the item least recently added to this queue
     * @throws NoSuchElementException if this queue is empty
     */
    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        return last.next.item;
    }

    /**
     * Adds the item to this queue.
     *
     * @param item the item to add
     */
    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if (isEmpty()) {
            last.next = last;
        } else {
            Node oldFirst = oldLast.next;
            oldLast.next = last;
            last.next = oldFirst;
        }
        N++;
        assert check();
    }

    /**
     * Removes and returns the item on this queue that was least recently added.
     *
     * @return the item on this queue that was least recently added
     * @throws NoSuchElementException if this queue is empty
     */
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        Item item = last.next.item;
        last.next = last.next.next;
        N--;
        if (isEmpty()) {
            last = null; // to avoid loitering
        }
        assert check();
        return item;
    }

    /**
     * Returns a string representation of this queue.
     *
     * @return the sequence of items in FIFO order, separated by spaces
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item).append(" ");
        }
        return s.toString();
    }

    // check internal invariants
    private boolean check() {
        if (N < 0) {
            return false;
        } else if (N == 0) {
            if (last != null) {
                return false;
            }
        } else if (N == 1) {
            if (last == null) {
                return false;
            }
            if (last.next == null) {
                return false;
            }
            if (last != last.next) {
                return false;
            }
            if (last.item == null || last.next.item == null) {
                return false;
            }
        } else {
            if (last == null) {
                return false;
            }
            if (last.next == null) {
                return false;
            }
            if (last == last.next) {
                return false;
            }
            if (last.item == null || last.next.item == null) {
                return false;
            }

            // check internal consistency of instance variable N
            int numberOfNodes = 1;
            for (Node x = last.next.next; x != null && x != last; x = x.next) {
                if (x.item == null) {
                    return false;
                }
                numberOfNodes++;
            }
            if (numberOfNodes != N) {
                return false;
            }
        }

        return true;
    }

    /**
     * Returns an iterator that iterates over the items in this queue in FIFO order.
     *
     * @return an iterator that iterates over the items in this queue in FIFO order
     */
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private Node current = last == null ? null : last.next;

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < N;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            index++;
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    /**
     * Unit tests the <tt>CircularLinkedQueue</tt> data type.
     */
    public static void main(String[] args) {
        CircularLinkedQueue<String> q = new CircularLinkedQueue<>();
        while (StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!"-".equals(item)) {
                q.enqueue(item);
            } else if (!q.isEmpty()) {
                StdOut.print(q.dequeue() + " ");
            }
        }
        StdOut.println("(" + q.size() + " left on queue)");
    }
}
