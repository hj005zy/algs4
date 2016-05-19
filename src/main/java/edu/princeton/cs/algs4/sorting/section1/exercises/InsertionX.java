/******************************************************************************
 *  Compilation:  javac InsertionX.java
 *  Execution:    java InsertionX < input.txt
 *  Dependencies: StdOut.java StdIn.java
 *  Data files:   http://algs4.cs.princeton.edu/21sort/tiny.txt
 *                http://algs4.cs.princeton.edu/21sort/words3.txt
 *  
 *  Sorts a sequence of strings from standard input using an optimized
 *  version of insertion sort that uses half exchanges instead of 
 *  full exchanges to reduce data movement..
 *
 *  % more tiny.txt
 *  S O R T E X A M P L E
 *
 *  % java InsertionX < tiny.txt
 *  A E E L M O P R S T X                 [ one string per line ]
 *
 *  % more words3.txt
 *  bed bug dad yes zoo ... all bad yet
 *
 *  % java InsertionX < words3.txt
 *  all bad bed bug dad ... yes yet zoo   [ one string per line ]
 *
 ******************************************************************************/
package edu.princeton.cs.algs4.sorting.section1.exercises;

import edu.princeton.cs.algs4.sorting.SortingHelper;
import edu.princeton.cs.algs4.util.StdIn;

/**
 *  The <tt>InsertionX</tt> class provides static methods for sorting
 *  an array using an optimized version of insertion sort (with half exchanges
 *  and a sentinel).
 *  <p>
 *  For additional documentation, see <a href="http://algs4.cs.princeton.edu/21elementary">Section 2.1</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class InsertionX {

    // This class should not be instantiated.
    private InsertionX() {
    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static <T extends Comparable<T>> void sort(T[] a) {
        int N = a.length;

        // put smallest element in position to serve as sentinel
        int exchanges = 0;
        for (int i = N - 1; i > 0; i--) {
            if (SortingHelper.less(a[i], a[i - 1])) {
                SortingHelper.exch(a, i, i - 1);
                exchanges++;
            }
        }
        if (exchanges == 0) {
            return;
        }

        // insertion sort with half-exchanges
        for (int i = 2; i < N; i++) {
            T v = a[i];
            int j = i;
            while (SortingHelper.less(v, a[j - 1])) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = v;
        }

        assert SortingHelper.isSorted(a);
    }

    /**
     * Reads in a sequence of strings from standard input; insertion sorts them;
     * and prints them to standard output in ascending order.
     */
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        InsertionX.sort(a);
        SortingHelper.show(a);
    }
}
