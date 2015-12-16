package edu.princeton.cs.fundamentals.bagsqueuesstacks.exercises.exercise38;

import java.util.NoSuchElementException;

public class ResizingArrayGeneralizedQueue<Item> {

    // queue elements
    private Item[] q;

    // number of elements on queue
    private int N;

    @SuppressWarnings("unchecked")
    public ResizingArrayGeneralizedQueue() {
        q = (Item[]) new Object[2];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    // resize the underlying array
    @SuppressWarnings("unchecked")
    private void resize(int max) {
        assert max >= N;
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = q[i];
        }
        q = temp;
    }

    /**
     * Adds the item to this queue.
     *
     * @param item the item to add
     */
    public void insert(Item item) {
        // double size of array if necessary and recopy to front of array
        if (N == q.length) {
            // double size of array if necessary
            resize(2 * q.length);
        }
        // add item
        q[N++] = item;
    }

    /**
     * Removes and returns the item on this queue that was kth least recently added.
     *
     * @return the item on this queue that was kth least recently added
     * @throws java.util.NoSuchElementException if this queue is empty
     */
    public Item delete(int k) {
        if (k > N) {
            throw new NoSuchElementException("Queue underflow");
        }
        Item item = q[k - 1];
        for (int i = k - 1; i < N; i++) {
            q[i] = q[i + 1];
        }
        q[--N] = null;
        // shrink size of array if necessary
        if (N > 0 && N == q.length / 4) {
            resize(q.length / 2);
        }
        return item;
    }
}
