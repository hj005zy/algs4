package edu.princeton.cs.algs4.sorting;

import java.util.Comparator;

import edu.princeton.cs.algs4.util.StdOut;

public class SortingHelper {

    // This class should not be instantiated.
    private SortingHelper() {
    }

    /***************************************************************************
     *  Helper sorting functions.
     ***************************************************************************/

    // is v < w ?
    public static <Key extends Comparable<Key>> boolean less(Key v, Key w) {
        return v.compareTo(w) < 0;
    }

    // is v < w ?
    public static <Key> boolean less(Comparator<Key> c, Key v, Key w) {
        return c.compare(v, w) < 0;
    }

    // exchange a[i] and a[j]  (for indirect sort)
    public static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // exchange a[i] and a[j]
    public static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    /***************************************************************************
     *  Check if array is sorted - useful for debugging.
     ***************************************************************************/

    // is the array a[] sorted?
    public static <Key extends Comparable<Key>> boolean isSorted(Key[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    // is the array sorted from a[lo] to a[hi]
    public static <Key extends Comparable<Key>> boolean isSorted(Key[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    // is the array a[] sorted?
    public static <Key> boolean isSorted(Key[] a, Comparator<Key> c) {
        return isSorted(a, c, 0, a.length - 1);
    }

    // is the array sorted from a[lo] to a[hi]
    public static <Key> boolean isSorted(Key[] a, Comparator<Key> c, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (less(c, a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    // is the array h-sorted?
    public static <Key extends Comparable<Key>> boolean isHsorted(Key[] a, int h) {
        for (int i = h; i < a.length; i++) {
            if (less(a[i], a[i - h])) {
                return false;
            }
        }
        return true;
    }

    // print array to standard output
    public static void show(Object[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }
}
