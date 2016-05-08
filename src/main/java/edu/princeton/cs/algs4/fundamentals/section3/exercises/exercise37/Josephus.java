package edu.princeton.cs.algs4.fundamentals.section3.exercises.exercise37;

import edu.princeton.cs.algs4.fundamentals.section3.Queue;
import edu.princeton.cs.algs4.util.StdOut;

/******************************************************************************
 * Compilation:  javac Josephus.java
 * Execution:    java Josephus N M
 * Dependencies: Queue.java
 *
 * Solves the Josephus problem.
 *
 * % java Josephus 7 2
 * 1 3 5 0 4 2 6
 ******************************************************************************/
public class Josephus {

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int M = Integer.parseInt(args[1]);

        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < N; i++) {
            queue.enqueue(i);
        }

        while (!queue.isEmpty()) {
            for (int i = 1; i < M; i++) {
                queue.enqueue(queue.dequeue());
            }
            StdOut.print(queue.dequeue() + " ");
        }
        StdOut.println();
    }
}
