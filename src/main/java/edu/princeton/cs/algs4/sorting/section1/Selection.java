/******************************************************************************
 *  Compilation:  javac Selection.java
 *  Execution:    java  Selection < input.txt
 *  Dependencies: StdOut.java StdIn.java
 *  Data files:   http://algs4.cs.princeton.edu/21sort/tiny.txt
 *                http://algs4.cs.princeton.edu/21sort/words3.txt
 *   
 *  Sorts a sequence of strings from standard input using selection sort.
 *   
 *  % more tiny.txt
 *  S O R T E X A M P L E
 *
 *  % java Selection < tiny.txt
 *  A E E L M O P R S T X                 [ one string per line ]
 *    
 *  % more words3.txt
 *  bed bug dad yes zoo ... all bad yet
 *  
 *  % java Selection < words3.txt
 *  all bad bed bug dad ... yes yet zoo    [ one string per line ]
 *
 ******************************************************************************/
package edu.princeton.cs.algs4.sorting.section1;

import java.util.Comparator;

import edu.princeton.cs.algs4.sorting.SortingHelper;
import edu.princeton.cs.algs4.util.StdIn;

/**
 *  The <tt>Selection</tt> class provides static methods for sorting an
 *  array using selection sort.
 *  <p>
 *  For additional documentation, see <a href="http://algs4.cs.princeton.edu/21elementary">Section 2.1</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class Selection {

    // This class should not be instantiated.
    private Selection() {
    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static <Key extends Comparable<Key>> void sort(Key[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (SortingHelper.less(a[j], a[min])) {
                    min = j;
                }
            }
            SortingHelper.exch(a, i, min);
            assert SortingHelper.isSorted(a, 0, i);
        }
        assert SortingHelper.isSorted(a);
    }

    /**
     * Rearranges the array in ascending order, using a comparator.
     * @param a the array
     * @param c the comparator specifying the order
     */
    public static <Key> void sort(Key[] a, Comparator<Key> c) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (SortingHelper.less(c, a[j], a[min])) {
                    min = j;
                }
            }
            SortingHelper.exch(a, i, min);
            assert SortingHelper.isSorted(a, c, 0, i);
        }
        assert SortingHelper.isSorted(a, c);
    }

    /**
     * Reads in a sequence of strings from standard input; selection sorts them; 
     * and prints them to standard output in ascending order. 
     */
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        Selection.sort(a);
        SortingHelper.show(a);
    }
}
