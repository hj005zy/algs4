package edu.princeton.cs.fundamentals.bagsqueuesstacks.exercises.exercise36;

import edu.princeton.cs.util.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomQueue<Item> implements Iterable<Item> {

    // queue elements
    private Item[] q;

    // number of elements on queue
    private int N;

    @SuppressWarnings("unchecked")
    public RandomQueue() {
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
    public void enqueue(Item item) {
        // double size of array if necessary and recopy to front of array
        if (N == q.length) {
            // double size of array if necessary
            resize(2 * q.length);
        }
        // add item
        q[N++] = item;
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
        int index = StdRandom.uniform(N);
        Item item = q[index];
        q[index] = q[N - 1];
        // to avoid loitering
        q[N - 1] = null;
        N--;
        // shrink size of array if necessary
        if (N > 0 && N == q.length / 4) {
            resize(q.length / 2);
        }
        return item;
    }

    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        return q[StdRandom.uniform(N)];
    }

    /**
     * Returns an iterator that iterates over the items in this queue in FIFO order.
     *
     * @return an iterator that iterates over the items in this queue in FIFO order
     */
    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ArrayIterator implements Iterator<Item> {

        private Item[] shuffledQueue;

        private int i = 0;

        public ArrayIterator() {
            for (int j = 0; j < q.length; j++) {
                shuffledQueue[j] = q[j];
            }
            StdRandom.shuffle(shuffledQueue);
        }

        @Override
        public boolean hasNext() {
            return i < N;
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
            return shuffledQueue[i++];
        }
    }

}
