/******************************************************************************
 *  Compilation:  javac ErdosRenyi.java
 *  Execution:    java ErdosRenyi N T
 *  Dependencies: StdRandom.java StdStats.java UF.java
 *
 *  Repeatedly add random edges (with replacement) to a graph on N
 *  vertices until the graph is connected. Report the mean and
 *  standard deviation of the number of edges added.
 *
 *  When N is large, Erdos and Renyi proved that after about 1/2 N ln N
 *  additions, the graph will have a 50/50 chance of being connected.
 *
 *  % java ErdosRenyi 100 1000
 *  1/2 N ln N = 230.25850929940458
 *  mean       = 263.584
 *  stddev     = 64.39309702134229
 *  
 *  % java ErdosRenyi 100 1000
 *  1/2 N ln N = 230.25850929940458
 *  mean       = 263.93
 *  stddev     = 63.54839966513712
 * 
 *  % java ErdosRenyi 12800 1000
 *  1/2 N ln N = 60526.08287940933
 *  mean       = 64231.526
 *  stddev     = 8362.273790143683
 *
 *
 *
 *         Computational Experiments
 *         --------------------------
 *
 *       N    mean # edges    1/2 N ln N
 *  ------------------------------------
 *     100            260            230
 *     200            600            530
 *     400           1300           1200
 *     800           2900           2700
 *    1600           6400           5900
 *    3200          14000          13000
 *    6400          30000          28000
 *   12800          64000          61000
 *   25600         140000         130000
 *   51200         290000         280000
 *  102400         620000         590000
 *  204800        1300000        1300000
 *  409600        2700000        2700000
 *
 ******************************************************************************/
package edu.princeton.cs.algs4.fundamentals.section5.exercises;

import edu.princeton.cs.algs4.fundamentals.section5.UF;
import edu.princeton.cs.algs4.util.StdOut;
import edu.princeton.cs.algs4.util.StdRandom;
import edu.princeton.cs.algs4.util.StdStats;

public class ErdosRenyi {

    public static int count(int N) {
        int edges = 0;
        UF uf = new UF(N);
        while (uf.count() > 1) {
            int p = StdRandom.uniform(N);
            int q = StdRandom.uniform(N);
            uf.union(p, q);
            edges++;
        }
        return edges;
    }

    public static void main(String[] args) {

        // number of vertices
        int n = Integer.parseInt(args[0]);
        // number of trials
        int t = Integer.parseInt(args[1]);
        int[] edges = new int[t];

        // repeat the experiment T times
        for (int i = 0; i < t; i++) {
            edges[i] = count(n);
        }

        // report statistics
        StdOut.println("1/2 N ln N = " + 0.5 * n * Math.log(n));
        StdOut.println("mean       = " + StdStats.mean(edges));
        StdOut.println("stddev     = " + StdStats.stddev(edges));
    }
}
