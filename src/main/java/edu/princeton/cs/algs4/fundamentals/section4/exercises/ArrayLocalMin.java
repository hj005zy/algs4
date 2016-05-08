package edu.princeton.cs.algs4.fundamentals.section4.exercises;

import java.util.HashSet;
import java.util.Set;

import edu.princeton.cs.algs4.util.StdOut;
import edu.princeton.cs.algs4.util.StdRandom;

public class ArrayLocalMin {

    private static int[] createArray(int n) {
        int min = n * -1000;
        int max = n * 1000;
        Set<Integer> set = new HashSet<>();
        while (set.size() != n) {
            set.add(StdRandom.uniform(min, max + 1));
        }
        int[] a = set.stream().mapToInt(Integer::intValue).toArray();
        StdRandom.shuffle(a);

        a[0] = Integer.MAX_VALUE;
        a[n - 1] = Integer.MAX_VALUE - 1;

        return a;
    }

    private static int searchLocalMin(int[] a) {
        int n = a.length;
        if (n == 1) {
            return 0;
        }
        if (a[0] < a[1]) {
            return 0;
        }
        if (a[n - 1] < a[n - 2]) {
            return n - 1;
        }
        int low = 0;
        int high = n - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (a[mid] < a[mid - 1] && a[mid] < a[mid + 1]) {
                return mid;
            } else if (a[mid] < a[mid - 1] && a[mid] > a[mid + 1]) {
                low = mid;
            } else if (a[mid] > a[mid - 1] && a[mid] > a[mid + 1]) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = createArray(100000);
        StdOut.println(searchLocalMin(a));
    }
}
