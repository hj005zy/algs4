package edu.princeton.cs.fundamentals.bagsqueuesstacks.exercises.exercise33;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayDeque<Item> implements Iterable<Item> {

    private Item[] q;

    private int N;

    @SuppressWarnings("unchecked")
    public ResizingArrayDeque() {
        q = (Item[]) new Object[2];
        N = 0;
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

    public void pushLeft(Item item) {
        if (N == q.length) {
            resize(2 * q.length);
        }
        for (int i = N - 1; i > 0; i--) {
            q[i + 1] = q[i];
        }
        q[0] = item;
        N++;
    }

    public void pushRight(Item item) {
        if (N == q.length) {
            resize(2 * q.length);
        }
        q[N++] = item;
    }

    public Item popLeft() {
        Item item = q[0];
        for (int i = 1; i < N - 1; i++) {
            q[i - 1] = q[i];
        }
        q[--N] = null;
        if (N > 0 && N == q.length / 4) {
            resize(q.length / 2);
        }
        return item;
    }

    public Item popRigt() {
        Item item = q[--N];
        q[N] = null;
        if (N > 0 && N == q.length / 4) {
            resize(q.length / 2);
        }
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ResizingArrayDequeIterator();
    }

    private class ResizingArrayDequeIterator implements Iterator<Item> {

        private int i = 0;

        @Override
        public boolean hasNext() {
            return i < N;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return q[i++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
