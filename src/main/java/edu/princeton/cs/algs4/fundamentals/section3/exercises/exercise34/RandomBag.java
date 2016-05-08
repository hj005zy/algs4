package edu.princeton.cs.algs4.fundamentals.section3.exercises.exercise34;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.util.StdRandom;

public class RandomBag<Item> implements Iterable<Item> {

    private Item[] bag;

    private int N;

    @SuppressWarnings("unchecked")
    public RandomBag() {
        bag = (Item[]) new Object[2];
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
            temp[i] = bag[i];
        }
        bag = temp;
    }

    public void add(Item item) {
        if (N == bag.length) {
            resize(2 * bag.length);
        }
        bag[N++] = item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomBagIterator();
    }

    private class RandomBagIterator implements Iterator<Item> {

        private int i = 0;

        private Item[] shuffledBag;

        public RandomBagIterator() {
            for (int j = 0; j < bag.length; j++) {
                shuffledBag[j] = bag[j];
            }
            StdRandom.shuffle(shuffledBag);
        }

        @Override
        public boolean hasNext() {
            return i < N;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return shuffledBag[i++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
